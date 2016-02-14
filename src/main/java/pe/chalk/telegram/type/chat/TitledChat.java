package pe.chalk.telegram.type.chat;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class TitledChat extends Chat {
    private final String title;

    protected TitledChat(final JSONObject json){
        super(json);
        this.title = json.getString("title");
    }

    public String getTitle(){
        return this.title;
    }
}
