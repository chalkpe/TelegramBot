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

package pe.chalk.telegram.type.user;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class User implements Identified<Integer>, Named, Usernamed {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String username;

    private User(final JSONObject json){
        this.id        = json.getInt("id");
        this.firstName = json.getString("first_name");
        this.lastName  = json.optString("last_name", null);
        this.username  = json.optString("username", null);
    }

    public static User create(final JSONObject json){
        return new User(json);
    }

    @Override
    public Integer getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    @Override
    public String getUsername(){
        return this.username;
    }
}
