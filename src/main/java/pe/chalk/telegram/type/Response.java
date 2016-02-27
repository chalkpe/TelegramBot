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

package pe.chalk.telegram.type;

import org.json.JSONObject;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Response {
    private final boolean ok;
    private final String description;

    private final Object result;
    private final int errorCode;

    private Response(JSONObject json){
        this.ok          = json.getBoolean("ok");
        this.description = json.optString("description", null);
        this.result      = json.opt("result");
        this.errorCode   = json.optInt("error_code", 200);
    }

    public static Response create(final JSONObject json){
        return new Response(json);
    }

    public boolean isOk(){
        return this.ok;
    }

    public String getDescription(){
        return this.description;
    }

    public Object getResult(){
        if(!this.isOk() || Objects.isNull(this.result)) throw new IllegalStateException(this.getErrorCode() + ": " + this.getDescription());
        return this.result;
    }

    public int getErrorCode(){
        return this.errorCode;
    }
}
