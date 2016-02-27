/*
 * Copyright (C) 2016  ChalkPE
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;
import pe.chalk.telegram.type.chat.Chat;
import pe.chalk.telegram.type.user.User;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Message implements Identified<Integer> {
    private final int id;
    private final int date;
    private final Chat chat;

    private final User from;
    private final Message replyToMessage;

    protected Message(final JSONObject json){
        this.id = json.getInt("message_id");
        this.date = json.getInt("date");
        this.chat = Chat.create(json.getJSONObject("chat"));

        this.from           = json.has("from")             ? User.create(json.getJSONObject("from"))                : null;
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

    public User getFrom(){
        return this.from;
    }

    public boolean hasFrom(){
        return Objects.nonNull(this.getFrom());
    }
}
