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

package pe.chalk.telegram.type.file.media;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.photo.PhotoSize;
import pe.chalk.telegram.type.file.photo.Sized;
import pe.chalk.telegram.type.file.photo.Thumbnail;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Video extends MimeTypeFile implements Sized, Sound, Thumbnail {
    private final int width;
    private final int height;
    private final int duration;
    private final PhotoSize thumb;

    private Video(final JSONObject json){
        super(json);
        this.width    = json.getInt("width");
        this.height   = json.getInt("height");
        this.duration = json.getInt("duration");
        this.thumb    = json.has("thumb") ? PhotoSize.create(json.getJSONObject("thumb")) : null;
    }

    public static Video create(final JSONObject json){
        return new Video(json);
    }

    @Override
    public int getWidth(){
        return this.width;
    }

    @Override
    public int getHeight(){
        return this.height;
    }

    @Override
    public int getDuration(){
        return this.duration;
    }

    @Override
    public PhotoSize getThumb(){
        return this.thumb;
    }
}
