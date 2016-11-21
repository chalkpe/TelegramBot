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

package pe.chalk.telegram.method;

import pe.chalk.telegram.type.chat.Chat;
import pe.chalk.telegram.type.message.Message;

@SuppressWarnings("unchecked")

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public abstract class MessageSender<T extends Message, S extends Sender<T, S>> extends Sender<T, S> {
    public MessageSender(long chatId){
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
