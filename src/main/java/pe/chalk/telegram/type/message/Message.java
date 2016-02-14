package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;
import pe.chalk.telegram.type.chat.Chat;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Message implements Identified<Integer> {
    private final int id;
    private final int date;
    private final Chat chat;

    private final Message replyToMessage;

    protected Message(final JSONObject json){
        this.id = json.getInt("message_id");
        this.date = json.getInt("date");
        this.chat = Chat.create(json.getJSONObject("chat"));

        this.replyToMessage = json.has("reply_to_message") ? Message.create(json.getJSONObject("reply_to_message")) : null;
    }

    public static Message create(final JSONObject json){
        if(json.has("text")) return TextMessage.create(json);
        else if(json.has("audio")) return AudioMessage.create(json);
        else if(json.has("document")) return DocumentMessage.create(json);
        else if(json.has("photo")) return PhotoMessage.create(json);
        else if(json.has("sticker")) return StickerMessage.create(json);
        else if(json.has("video")) return VideoMessage.create(json);
        else if(json.has("voice")) return VoiceMessage.create(json);
        else if(json.has("contact")) return ContactMessage.create(json);
        else if(json.has("location")) return LocationMessage.create(json);
        else return new Message(json);
    }

    @Override
    public Integer getId(){
        return this.id;
    }

    public int getDate(){
        return this.date;
    }

    public Chat getChat(){
        return this.chat;
    }

    public Message getReplyToMessage(){
        return this.replyToMessage;
    }

    public boolean isReply(){
        return Objects.nonNull(this.getReplyToMessage());
    }
}