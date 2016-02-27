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
