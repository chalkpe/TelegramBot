package pe.chalk.telegram.type.inline;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class ChosenInlineResult {
    private ChosenInlineResult(final JSONObject json){

    }

    public static ChosenInlineResult create(final JSONObject json){
        return new ChosenInlineResult(json);
    }
}
