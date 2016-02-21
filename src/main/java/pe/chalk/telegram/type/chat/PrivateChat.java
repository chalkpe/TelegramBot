package pe.chalk.telegram.type.chat;

import org.json.JSONObject;
import pe.chalk.telegram.type.user.Named;
import pe.chalk.telegram.type.user.Usernamed;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class PrivateChat extends Chat implements Named, Usernamed {
    private final String username;
    private final String firstName;
    private final String lastName;

    protected PrivateChat(final JSONObject json){
        super(json);
        this.username  = json.optString("username", null);
        this.firstName = json.optString("first_name", null);
        this.lastName  = json.optString("last_name", null);
    }

    public static PrivateChat create(final JSONObject json){
        return new PrivateChat(json);
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName(){
        return this.lastName;
    }
}
