package pe.chalk.telegram.type.reply;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class ReplyKeyboardHide {
    private ReplyKeyboardHide(final JSONObject json){

    }

    public static ReplyKeyboardHide create(final JSONObject json){
        return new ReplyKeyboardHide(json);
    }
}
