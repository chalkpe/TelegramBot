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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class UserProfilePhotos {
    private final int totalCount;
    private final List<Photo> photos;

    private UserProfilePhotos(final JSONObject json){
        this.totalCount = json.getInt("total_count");
        this.photos     = JSONHelper.buildStream(json.getJSONArray("photos"), JSONArray.class).map(Photo::create).collect(Collectors.toList());
    }

    public static UserProfilePhotos create(final JSONObject json){
        return new UserProfilePhotos(json);
    }

    public int getTotalCount(){
        return this.totalCount;
    }

    public List<Photo> getPhotos(){
        return this.photos;
    }
}
