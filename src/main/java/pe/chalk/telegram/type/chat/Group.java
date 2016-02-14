package pe.chalk.telegram.type.chat;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Group extends TitledChat {
    protected Group(final JSONObject json){
        super(json);
    }

    public static Group create(final JSONObject json){
        return new Group(json);
    }
}
