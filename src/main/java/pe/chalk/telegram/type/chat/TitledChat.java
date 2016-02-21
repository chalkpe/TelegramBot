package pe.chalk.telegram.type.chat;

import org.json.JSONObject;
import pe.chalk.telegram.type.Titled;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class TitledChat extends Chat implements Titled {
    private final String title;

    protected TitledChat(final JSONObject json){
        super(json);
        this.title = json.getString("title");
    }

    @Override
    public String getTitle(){
        return this.title;
    }
}
