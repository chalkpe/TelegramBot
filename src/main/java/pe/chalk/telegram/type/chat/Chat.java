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

package pe.chalk.telegram.type.chat;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class Chat implements Identified<Long> {
    public class Type {
        public static final String PRIVATE = "private";
        public static final String GROUP = "group";
        public static final String SUPERGROUP = "supergroup";
        public static final String CHANNEL = "channel";
    }

    private final long id;
    private final String type;

    protected Chat(final JSONObject json){
        this.id   = json.getLong("id");
        this.type = json.getString("type");
    }

    public static Chat create(final JSONObject json){
        switch(json.getString("type")){
            case Type.PRIVATE:
                return PrivateChat.create(json);

            case Type.GROUP:
                return Group.create(json);

            case Type.SUPERGROUP:
                return Supergroup.create(json);

            case Type.CHANNEL:
                return Channel.create(json);

            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public Long getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }

    public boolean isPrivateChat(){
        return this.getType().equals(Type.PRIVATE);
    }

    public boolean isGroup(){
        return this.isGroup(false);
    }

    public boolean isGroup(final boolean exact){
        final boolean isGroup = this.getType().equals(Type.GROUP);
        return exact ? isGroup : (isGroup || this.isSupergroup());
    }

    public boolean isSupergroup(){
        return this.getType().equals(Type.SUPERGROUP);
    }

    public boolean isChannel(){
        return this.getType().equals(Type.CHANNEL);
    }
}
