package pe.chalk.telegram.type;

import org.json.JSONObject;
import pe.chalk.telegram.type.inline.ChosenInlineResult;
import pe.chalk.telegram.type.inline.InlineQuery;
import pe.chalk.telegram.type.message.Message;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Update implements Identified<Integer> {
    public static int latestId = 0;

    private final int id;
    private final Message message;
    private final InlineQuery inlineQuery;
    private final ChosenInlineResult chosenInlineResult;

    private Update(final JSONObject json){
        this.id                 = json.getInt("update_id");
        this.message            = json.has("message")              ? Message.create(json.getJSONObject("message"))                         : null;
        this.inlineQuery        = json.has("inline_query")         ? InlineQuery.create(json.getJSONObject("inline_query"))                : null;
        this.chosenInlineResult = json.has("chosen_inline_result") ? ChosenInlineResult.create(json.getJSONObject("chosen_inline_result")) : null;

        if(id > Update.latestId) Update.latestId = id;
    }

    public static Update create(final JSONObject json){
        return new Update(json);
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
