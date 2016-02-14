package pe.chalk.telegram.type.message;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class CaptionedMessage extends Message {
    private final String caption;
    protected CaptionedMessage(final JSONObject json){
        super(json);
        this.caption = json.optString("caption", null);
    }

    public String getCaption(){
        return this.caption;
    }
}
