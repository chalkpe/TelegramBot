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
import pe.chalk.telegram.type.user.Contact;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class ContactMessage extends Message {
    private final Contact contact;
    private ContactMessage(final JSONObject json){
        super(json);
        this.contact = Contact.create(json.getJSONObject("contact"));
    }

    public static ContactMessage create(final JSONObject json){
        return new ContactMessage(json);
    }

    public Contact getContact(){
        return this.contact;
    }
}
