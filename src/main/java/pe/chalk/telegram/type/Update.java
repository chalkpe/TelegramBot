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
import pe.chalk.telegram.type.inline.ChosenInlineResult;
import pe.chalk.telegram.type.inline.InlineQuery;
import pe.chalk.telegram.type.message.Message;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Update implements Identified<Integer> {
    public static int latestId = 0;

    private final int id;
    private final Message message;
    private final InlineQuery inlineQuery;
    private final ChosenInlineResult chosenInlineResult;

    private Update(final JSONObject json){
        this.id                 = json.getInt("update_id");
        this.message            = json.has("message")              ? Message.create(json.getJSONObject("message"))                         : null;
        this.inlineQuery        = json.has("inline_query")         ? InlineQuery.create(json.getJSONObject("inline_query"))                : null;
        this.chosenInlineResult = json.has("chosen_inline_result") ? ChosenInlineResult.create(json.getJSONObject("chosen_inline_result")) : null;

        if(id > Update.latestId) Update.latestId = id;
    }

    public static Update create(final JSONObject json){
        return new Update(json);
    }

    @Override
    public Integer getId(){
        return this.id;
    }

    public Message getMessage(){
        return this.message;
    }

    public InlineQuery getInlineQuery(){
        return this.inlineQuery;
    }

    public boolean hasInlineQuery(){
        return Objects.nonNull(this.getInlineQuery());
    }

    public ChosenInlineResult getChosenInlineResult(){
        return this.chosenInlineResult;
    }

    public boolean hasChosenInlineResult(){
        return Objects.nonNull(this.getChosenInlineResult());
    }
}
