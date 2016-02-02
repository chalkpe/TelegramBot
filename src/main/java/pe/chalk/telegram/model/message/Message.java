package pe.chalk.telegram.model.message;

import pe.chalk.telegram.model.chat.Chat;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class Message {
    private final int id;
    private final int date;
    private final Chat chat;

    public Message(final int id, final int date, final Chat chat){
        this.id = id;
        this.date = date;
        this.chat = chat;
    }
}
