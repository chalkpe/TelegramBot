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

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class TextMessage extends Message {
    private final String text;
    private TextMessage(final JSONObject json){
        super(json);
        this.text = json.getString("text");
    }

    public static TextMessage create(final JSONObject json){
        return new TextMessage(json);
    }

    public String getText(){
        return this.text;
    }
}
