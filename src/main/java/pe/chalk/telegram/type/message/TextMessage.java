package pe.chalk.telegram.type.message;

import pe.chalk.telegram.type.chat.Chat;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class TextMessage extends Message {
    private final String text;

    private TextMessage(final int id, final int date, final Chat chat, final String text){
        super(id, date, chat);
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
