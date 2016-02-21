package pe.chalk.telegram.type.reply;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class ForceReply {
    //private final boolean forceReply = true;
    private final boolean selective;

    private ForceReply(final JSONObject json){
        this.selective = json.optBoolean("selective");
    }

    public static ForceReply create(final JSONObject json){
        return new ForceReply(json);
    }

    public boolean isSelective(){
        return this.selective;
    }
}
