package pe.chalk.telegram.method;

import pe.chalk.telegram.type.chat.Chat;
import pe.chalk.telegram.type.message.Message;

@SuppressWarnings("unchecked")

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public abstract class MessageSender<T extends Message, S extends Sender<T, S>> extends Sender<T, S> {
    public MessageSender(int chatId){
        super(chatId);
    }

    public MessageSender(String chatId){
        super(chatId);
    }

    public MessageSender(Chat chat){
        super(chat);
    }

    public final S replyToMessageId(final int replyToMessageId){
        this.parameters.put("reply_to_message_id", replyToMessageId);
        return (S) this;
    }

    public final S replyToMessage(final Message replyToMessage){
        this.replyToMessageId(replyToMessage.getId());
        return (S) this;
    }
}
