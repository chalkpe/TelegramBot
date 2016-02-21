package pe.chalk.telegram.method;

import org.json.JSONObject;
import pe.chalk.telegram.TelegramBot;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.user.User;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public class MeGetter {
    public User get(final TelegramBot bot){
        final Response response = bot.request("getMe");
        return User.create((JSONObject) response.getResult());
    }
}
