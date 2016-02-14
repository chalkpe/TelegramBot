package pe.chalk.telegram.type;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Response {
    private final boolean ok;
    private final String description;

    private final JSONObject result;
    private final int errorCode;

    public Response(JSONObject json){
        this.ok = json.getBoolean("ok");
        this.description = json.has("description") ? json.getString("description") : null;
        this.result = json.has("result") ? json.getJSONObject("result") : null;
        this.errorCode = json.has("error_code") ? json.getInt("error_code") : 200;
    }

    public boolean isOk(){
        return this.ok;
    }

    public String getDescription(){
        return this.description;
    }

    public JSONObject getResult(){
        return this.result;
    }

    public int getErrorCode(){
        return this.errorCode;
    }
}
