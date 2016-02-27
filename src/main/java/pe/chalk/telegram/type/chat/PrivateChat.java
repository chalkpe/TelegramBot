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
import pe.chalk.telegram.type.user.Named;
import pe.chalk.telegram.type.user.Usernamed;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class PrivateChat extends Chat implements Named, Usernamed {
    private final String username;
    private final String firstName;
    private final String lastName;

    protected PrivateChat(final JSONObject json){
        super(json);
        this.username  = json.optString("username", null);
        this.firstName = json.optString("first_name", null);
        this.lastName  = json.optString("last_name", null);
    }

    public static PrivateChat create(final JSONObject json){
        return new PrivateChat(json);
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName(){
        return this.lastName;
    }
}
