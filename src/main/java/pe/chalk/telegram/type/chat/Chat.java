package pe.chalk.telegram.type.chat;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class Chat implements Identified<Integer> {
    public class Type {
        public static final String PRIVATE = "private";
        public static final String GROUP = "group";
        public static final String SUPERGROUP = "supergroup";
        public static final String CHANNEL = "channel";
    }

    private final int id;
    private final String type;

    protected Chat(final JSONObject json){
        this.id   = json.getInt("id");
        this.type = json.getString("type");
    }

    public static Chat create(final JSONObject json){
        switch(json.getString("type")){
            case Type.PRIVATE:
                return PrivateChat.create(json);

            case Type.GROUP:
                return Group.create(json);

            case Type.SUPERGROUP:
                return Supergroup.create(json);

            case Type.CHANNEL:
                return Channel.create(json);

            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public Integer getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }

    public boolean isPrivateChat(){
        return this.getType().equals(Type.PRIVATE);
    }

    public boolean isGroup(){
        return this.isGroup(false);
    }

    public boolean isGroup(final boolean exact){
        final boolean isGroup = this.getType().equals(Type.GROUP);
        return exact ? isGroup : (isGroup || this.isSupergroup());
    }

    public boolean isSupergroup(){
        return this.getType().equals(Type.SUPERGROUP);
    }

    public boolean isChannel(){
        return this.getType().equals(Type.CHANNEL);
    }
}
