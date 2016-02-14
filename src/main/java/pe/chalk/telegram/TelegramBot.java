package pe.chalk.telegram;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import pe.chalk.telegram.handler.UpdateHandler;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.Update;
import pe.chalk.telegram.type.user.User;
import pe.chalk.telegram.util.JSONHelper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
            this.getUpdates();
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
                try(OutputStream stream = connection.getOutputStream()){
                    stream.write(parameters.toString().getBytes(StandardCharsets.UTF_8));
                }
            }

            final JSONObject response = new JSONObject(new JSONTokener(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)));
            System.out.println(new Date().toString() + " " + response.toString());

            return Response.create(response);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public User getMe(){
        final Response response = this.request("getMe");
        return User.create((JSONObject) response.getResult());
    }

    public void getUpdates(){
        final JSONObject parameters = new JSONObject();
        if(Update.latestId > 0) parameters.put("offset", Update.latestId + 1);

        final Response response = this.request("getUpdates", parameters);

        final List<Update> updates = JSONHelper.buildStream((JSONArray) response.getResult(), JSONObject.class).map(Update::create).collect(Collectors.toList());
        if(!updates.isEmpty()) this.getHandlers().forEach(handler -> handler.handleMessage(updates));
    }
}
