package pe.chalk.telegram.model.chat;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Group extends TitledChat {
    protected Group(final int id, final String title){
        this(id, Type.GROUP, title);
    }

    protected Group(final int id, final String type, final String title){
        super(id, type, title);
    }

    public static Group create(final JSONObject json){
        if(json.getString("type").equals(Type.SUPERGROUP)) return new Supergroup(json.getInt("id"), json.getString("title"));
        else return new Group(json.getInt("id"), json.getString("title"));
    }
}
