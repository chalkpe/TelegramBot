package pe.chalk.telegram.type.user;

import com.sun.istack.internal.Nullable;
import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class User implements Named, Usernamed {
    private final int id;
    private final String firstName;
    @Nullable private final String lastName;
    @Nullable private final String username;

    public User(final JSONObject json) {
        this.id        = json.getInt("id");
        this.firstName = json.getString("first_name");
        this.lastName  = json.has("last_name") ? json.getString("last_name") : null;
        this.username  = json.has("username")  ? json.getString("username")  : null;
    }

    public int getId(){
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
