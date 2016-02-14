package pe.chalk.telegram.type.message;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class TextMessage extends Message {
    private final String text;

    private TextMessage(final JSONObject json){
        super(json);
        this.text = json.getString("text");
    }

    public static TextMessage create(final JSONObject json){
        return new TextMessage(json);
    }

    public String getText(){
        return this.text;
    }
}
