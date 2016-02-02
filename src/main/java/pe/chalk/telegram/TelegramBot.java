package pe.chalk.telegram;

import org.json.JSONObject;
import org.json.JSONTokener;
import pe.chalk.telegram.handler.MessageHandler;
import pe.chalk.telegram.model.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class TelegramBot extends Thread {
    public static final String REQUEST_URL = "https://api.telegram.org/bot%s/%s";

    protected final String token;
    protected final List<MessageHandler> handlers;

    public TelegramBot(final String token){
        this(token, new ArrayList<>());
    }

    public TelegramBot(final String token, final List<MessageHandler> handlers){
        Objects.requireNonNull(token);
        Objects.requireNonNull(handlers);

        this.token = token;
        this.handlers = handlers;
    }

    public String getToken(){
        return this.token;
    }

    public List<MessageHandler> getHandlers(){
        return this.handlers;
    }

    public boolean addHandler(final MessageHandler handler){
        return this.handlers.add(handler);
    }

    public boolean removeHandler(final MessageHandler handler){
        return this.handlers.remove(handler);
    }

    @Override
    public void run(){
        while(true){
            if(Thread.interrupted()) break;
            this.getUpdates();
        }
    }

    public Response request(final String method, final JSONObject parameters){
        try{
            final URL url = new URL(String.format(TelegramBot.REQUEST_URL, this.getToken(), method));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            try(OutputStream stream = connection.getOutputStream()){
                stream.write(parameters.toString().getBytes(StandardCharsets.UTF_8));
            }

            return new Response(new JSONObject(new JSONTokener(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))));
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void getUpdates(){
        final Response response = this.request("getUpdates", new JSONObject());
        if(response != null) this.getHandlers().forEach(handler -> handler.handleMessage(response));
    }
}
