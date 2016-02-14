package pe.chalk.telegram.type;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class ForceReply {
    private ForceReply(final JSONObject json){

    }

    public static ForceReply create(final JSONObject json){
        return new ForceReply(json);
    }
}
