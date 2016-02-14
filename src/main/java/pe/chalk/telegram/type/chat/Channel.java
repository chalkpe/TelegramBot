package pe.chalk.telegram.type.chat;

import org.json.JSONObject;
import pe.chalk.telegram.type.user.Usernamed;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Channel extends TitledChat implements Usernamed {
    private final String username;

    private Channel(final JSONObject json){
        super(json);
        this.username = json.optString("username", null);
    }

    public static Channel create(final JSONObject json){
        return new Channel(json);
    }

    @Override
    public String getUsername(){
        return this.username;
    }
}
