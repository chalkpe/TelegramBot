package pe.chalk.telegram.util;

import org.json.JSONObject;
import pe.chalk.telegram.type.message.Message;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-19
 */
public class MessageOption {
    private final JSONObject parameters = new JSONObject();

    public MessageOption(final int chatId, final String text){
        this.chatId(chatId).text(text);
    }

    public MessageOption(final String chatId, final String text){
        this.chatId(chatId).text(text);
    }

    public MessageOption(final int chatId, final String text, final ParseMode parseMode){
        this.chatId(chatId).text(text).parseMode(parseMode);
    }

    public MessageOption(final String chatId, final String text, final ParseMode parseMode){
        this.chatId(chatId).text(text).parseMode(parseMode);
    }

    public MessageOption(final int chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview);
    }

    public MessageOption(final String chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview);
    }

    public MessageOption(final int chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview, final int replyToMessageId){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview).replyToMessageId(replyToMessageId);
    }

    public MessageOption(final String chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview, final int replyToMessageId){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview).replyToMessageId(replyToMessageId);
    }

    public MessageOption(final int chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview, final Message replyToMessage){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview).replyToMessage(replyToMessage);
    }

    public MessageOption(final String chatId, final String text, final ParseMode parseMode, final boolean disableWebPagePreview, final Message replyToMessage){
        this.chatId(chatId).text(text).parseMode(parseMode).disableWebPagePreview(disableWebPagePreview).replyToMessage(replyToMessage);
    }

    public MessageOption chatId(final int chatId){
        this.parameters.put("chat_id", chatId);
        return this;
    }

    public MessageOption chatId(final String chatId){
        if(chatId.startsWith("@")) this.parameters.put("chat_id", chatId);
        return this;
    }

    public MessageOption text(final String text){
        this.parameters.put("text", text);
        return this;
    }

    public MessageOption parseMode(final ParseMode parseMode){
        if(Objects.isNull(parseMode)) this.parameters.remove("parse_mode");
        else this.parameters.put("parse_mode", parseMode.getValue());
        return this;
    }

    public MessageOption disableWebPagePreview(final boolean disableWebPagePreview){
        this.parameters.put("disable_web_page_preview", disableWebPagePreview);
        return this;
    }

    public MessageOption replyToMessageId(final int replyToMessageId){
        this.parameters.put("reply_to_message_id", replyToMessageId);
        return this;
    }

    public MessageOption replyToMessage(final Message replyToMessage){
        this.replyToMessageId(replyToMessage.getId());
        return this;
    }

    public JSONObject getParameters(){
        return this.parameters;
    }
}
