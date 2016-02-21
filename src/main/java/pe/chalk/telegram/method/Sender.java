package pe.chalk.telegram.method;

import org.json.JSONObject;
import pe.chalk.telegram.TelegramBot;
import pe.chalk.telegram.type.chat.Chat;

@SuppressWarnings("unchecked")

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public abstract class Sender<T, S extends Sender<T, S>> {
    protected final JSONObject parameters = new JSONObject();

    public Sender(final int chatId){
        this.chatId(chatId);
    }

    public Sender(final String chatId){
        this.chatId(chatId);
    }

    public Sender(final Chat chat){
        this.chat(chat);
    }

    public final S chatId(final int chatId){
        this.parameters.put("chat_id", chatId);
        return (S) this;
    }

    public final S chatId(final String chatId){
        if(chatId.startsWith("@")) this.parameters.put("chat_id", chatId);
        return (S) this;
    }

    public final S chat(final Chat chat){
        this.chatId(chat.getId());
        return (S) this;
    }

    public JSONObject getParameters(){
        return this.parameters;
    }

    public abstract T send(final TelegramBot bot);
}
