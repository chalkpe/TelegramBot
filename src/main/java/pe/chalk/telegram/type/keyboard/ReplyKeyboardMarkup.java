package pe.chalk.telegram.type.keyboard;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class ReplyKeyboardMarkup {
    private ReplyKeyboardMarkup(final JSONObject json){

    }

    public static ReplyKeyboardMarkup create(final JSONObject json){
        return new ReplyKeyboardMarkup(json);
    }
}
