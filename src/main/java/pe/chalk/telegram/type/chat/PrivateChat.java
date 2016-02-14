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

    protected PrivateChat(final int id, final String username, final String firstName, final String lastName){
        super(id, Type.PRIVATE);

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static PrivateChat create(final JSONObject json){
        return new PrivateChat(json.getInt("id"), json.getString("username"), json.getString("first_name"), json.getString("last_name"));
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
