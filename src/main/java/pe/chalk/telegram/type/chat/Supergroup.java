package pe.chalk.telegram.type.chat;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Supergroup extends Group {
    private Supergroup(final JSONObject json){
        super(json);
    }
}
