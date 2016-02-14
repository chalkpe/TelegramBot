package pe.chalk.telegram.type.inline;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class InlineQuery {
    private InlineQuery(final JSONObject json){

    }

    public static InlineQuery create(final JSONObject json){
        return new InlineQuery(json);
    }
}
