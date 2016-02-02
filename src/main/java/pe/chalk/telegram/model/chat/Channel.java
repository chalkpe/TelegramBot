package pe.chalk.telegram.model.chat;

import org.json.JSONObject;
import pe.chalk.telegram.model.user.Usernamed;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Channel extends TitledChat implements Usernamed {
    private final String username;

    private Channel(int id, String title, String username){
        super(id, Type.CHANNEL, title);
        this.username = username;
    }

    public static Channel create(final JSONObject json){
        return new Channel(json.getInt("id"), json.getString("title"), json.getString("username"));
    }

    @Override
    public String getUsername(){
        return this.username;
    }
}
