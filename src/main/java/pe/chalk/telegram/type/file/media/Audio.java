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
import pe.chalk.telegram.type.Titled;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Audio extends MimeTypeFile implements Titled, Sound {
    private final int duration;
    private final String performer;
    private final String title;

    private Audio(final JSONObject json){
        super(json);
        this.duration  = json.getInt("duration");
        this.performer = json.optString("performer", null);
        this.title     = json.optString("title", null);
    }

    public static Audio create(final JSONObject json){
        return new Audio(json);
    }

    @Override
    public int getDuration(){
        return this.duration;
    }

    public String getPerformer(){
        return this.performer;
    }

    @Override
    public String getTitle(){
        return this.title;
    }
}
