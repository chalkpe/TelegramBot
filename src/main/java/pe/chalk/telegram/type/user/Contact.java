package pe.chalk.telegram.type.user;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Contact implements Named, Identified<Integer> {
    private final String phoneNumber;
    private final String firstName;
    private final String lastName;
    private final Integer userId;

    private Contact(final JSONObject json){
        this.phoneNumber = json.getString("phone_number");
        this.firstName   = json.getString("first_name");
        this.lastName    = json.optString("last_name", null);
        this.userId      = json.optInt("user_id");
    }

    public static Contact create(final JSONObject json){
        return new Contact(json);
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName(){
        return this.lastName;
    }

    public Integer getId(){
        return this.userId;
    }
}
