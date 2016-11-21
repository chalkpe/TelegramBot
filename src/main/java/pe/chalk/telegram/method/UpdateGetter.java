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

package pe.chalk.telegram.method;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.telegram.TelegramBot;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.Update;
import pe.chalk.telegram.util.JSONHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public class UpdateGetter {
    public List<Update> get(final TelegramBot bot){
        final JSONObject parameters = new JSONObject();
        if(Update.latestId > 0) parameters.put("offset", Update.latestId + 1);

        final Response response = bot.request("getUpdates", parameters);

        if(Objects.isNull(response)) return Collections.emptyList();
        return JSONHelper.buildStream((JSONArray) response.getResult(), JSONObject.class).map(Update::create).collect(Collectors.toList());
    }
}
