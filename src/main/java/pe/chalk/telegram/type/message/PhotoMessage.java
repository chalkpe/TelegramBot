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
import pe.chalk.telegram.type.file.photo.Photo;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class PhotoMessage extends CaptionedMessage {
    private final Photo photo;
    private PhotoMessage(JSONObject json){
        super(json);
        this.photo = Photo.create(json.getJSONArray("photo"));
    }

    public static PhotoMessage create(final JSONObject json){
        return new PhotoMessage(json);
    }

    public Photo getPhoto(){
        return this.photo;
    }
}
