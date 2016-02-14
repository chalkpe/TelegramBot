package pe.chalk.telegram.type;

import org.json.JSONObject;
import pe.chalk.telegram.type.message.Message;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Update implements Identified<Integer> {
    private final int id;
    private final Message message;
    private final InlineQuery inlineQuery;
    private final ChosenInlineResult chosenInlineResult;

    public Update(final JSONObject json){
        this.id = json.getInt("update_id");
        this.message = null;
        this.inlineQuery = null;
        this.chosenInlineResult = null;
    }

    @Override
    public Integer getId(){
        return this.id;
    }

    public Message getMessage(){
        return this.message;
    }

    public InlineQuery getInlineQuery(){
        return this.inlineQuery;
    }

    public ChosenInlineResult getChosenInlineResult(){
        return this.chosenInlineResult;
    }
}
