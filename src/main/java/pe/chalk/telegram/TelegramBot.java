/*
 * Copyright (C) 2016  ChalkPE
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pe.chalk.telegram;

import org.json.JSONObject;
import org.json.JSONTokener;
import pe.chalk.telegram.handler.UpdateHandler;
import pe.chalk.telegram.method.UpdateGetter;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.Update;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class TelegramBot extends Thread {
    public static final String REQUEST_URL = "https://api.telegram.org/bot%s/%s";

    protected final String token;
    protected final List<UpdateHandler> handlers;

    public TelegramBot(final String token){
        this(token, new ArrayList<>());
    }

    public TelegramBot(final String token, final List<UpdateHandler> handlers){
        Objects.requireNonNull(token);
        Objects.requireNonNull(handlers);

        this.token = token;
        this.handlers = handlers;
    }

    public String getToken(){
        return this.token;
    }

    public List<UpdateHandler> getHandlers(){
        return this.handlers;
    }

    public boolean addHandler(final UpdateHandler handler){
        return this.handlers.add(handler);
    }

    public boolean removeHandler(final UpdateHandler handler){
        return this.handlers.remove(handler);
    }

    @Override
    public void run(){
        while(true){
            if(Thread.interrupted()) break;

            final List<Update> updates = new UpdateGetter().get(this);
            if(!updates.isEmpty()) this.getHandlers().forEach(handler -> handler.handleMessage(updates));
        }
    }

    public Response request(final String method){
        return this.request(method, new JSONObject());
    }

    public Response request(final String method, final JSONObject parameters){
        try{
            final URL url = new URL(String.format(TelegramBot.REQUEST_URL, this.getToken(), method));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            if(parameters.length() > 0){
                connection.setDoOutput(true);
                try(final OutputStream stream = connection.getOutputStream()){
                    stream.write(parameters.toString().getBytes(StandardCharsets.UTF_8));
                }
                this.getLogger().finest(String.format("%s%n", parameters.toString(2)));
            }

            final JSONObject response = new JSONObject(new JSONTokener(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)));
            this.getLogger().finer(String.format("%s%n", response.toString(2)));

            return Response.create(response);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private class StandardHandler extends ConsoleHandler {
        public StandardHandler(final Level level){
            this.setLevel(level);
        }

        @Override
        protected synchronized void setOutputStream(final OutputStream ignored) throws SecurityException {
            super.setOutputStream(System.out);
        }
    }

    public Logger getLogger(){
        return Logger.getLogger(this.getClass().getCanonicalName());
    }

    public Logger initLogger(final Level level){
        final Logger logger = this.getLogger();
        for(Handler handler: logger.getHandlers()) logger.removeHandler(handler);

        logger.setUseParentHandlers(false);
        logger.addHandler(new StandardHandler(level));
        logger.setLevel(level);

        return logger;
    }
}
