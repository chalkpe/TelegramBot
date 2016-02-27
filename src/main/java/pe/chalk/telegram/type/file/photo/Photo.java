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

package pe.chalk.telegram.type.file.photo;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.telegram.util.JSONHelper;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class Photo extends ArrayList<PhotoSize> {
    private Photo(final JSONArray json){
        super(JSONHelper.buildStream(json, JSONObject.class).map(PhotoSize::create).collect(Collectors.toList()));
    }

    public static Photo create(final JSONArray json){
        return new Photo(json);
    }
}
