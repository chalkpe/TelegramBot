package pe.chalk.telegram.type;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.telegram.util.JSONHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Response {
    private final boolean ok;
    private final String description;

    private final Object result;
    private final int errorCode;

    private Response(JSONObject json){
        this.ok = json.getBoolean("ok");
        this.description = json.has("description") ? json.getString("description") : null;
        this.result = json.has("result") ? json.get("result") : null;
        this.errorCode = json.has("error_code") ? json.getInt("error_code") : 200;
    }

    public static Response create(final JSONObject json){
        return new Response(json);
    }

    public boolean isOk(){
        return this.ok;
    }

    public String getDescription(){
        return this.description;
    }

    public Object getResult(){
        return this.result;
    }

    public int getErrorCode(){
        return this.errorCode;
    }
}
