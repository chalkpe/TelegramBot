package pe.chalk.telegram.method;

import org.json.JSONObject;
import pe.chalk.telegram.TelegramBot;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.chat.Chat;
import pe.chalk.telegram.type.message.Message;
import pe.chalk.telegram.type.message.TextMessage;
import pe.chalk.telegram.util.ParseMode;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-19
 */
public class TextMessageSender extends MessageSender<TextMessage, TextMessageSender> {
    public TextMessageSender(final int chatId, final String text){
        super(chatId);
        this.text(text);
    }

    public TextMessageSender(final String chatId, final String text){
        super(chatId);
        this.text(text);
    }

    public TextMessageSender(final Chat chat, final String text){
        super(chat);
        this.text(text);
    }

    public TextMessageSender text(final String text){
        this.parameters.put("text", text);
        return this;
    }

    public TextMessageSender parseMode(final ParseMode parseMode){
        if(Objects.isNull(parseMode)) this.parameters.remove("parse_mode");
        else this.parameters.put("parse_mode", parseMode.getValue());
        return this;
    }

    public TextMessageSender disableWebPagePreview(final boolean disableWebPagePreview){
        this.parameters.put("disable_web_page_preview", disableWebPagePreview);
        return this;
    }

    @Override
    public TextMessage send(TelegramBot bot){
        final Response response = bot.request("sendMessage", this.getParameters());
        return (TextMessage) Message.create((JSONObject) response.getResult());
    }
}
