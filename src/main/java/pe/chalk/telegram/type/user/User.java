package pe.chalk.telegram.type.user;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class User implements Identified<Integer>, Named, Usernamed {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String username;

    private User(final JSONObject json){
        this.id        = json.getInt("id");
        this.firstName = json.getString("first_name");
        this.lastName  = json.optString("last_name", null);
        this.username  = json.optString("username", null);
    }

    public static User create(final JSONObject json){
        return new User(json);
    }

    @Override
    public Integer getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    @Override
    public String getUsername(){
        return this.username;
    }
}
