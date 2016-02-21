package pe.chalk.telegram.method;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.telegram.TelegramBot;
import pe.chalk.telegram.type.Response;
import pe.chalk.telegram.type.Update;
import pe.chalk.telegram.util.JSONHelper;

import java.util.List;
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
        return JSONHelper.buildStream((JSONArray) response.getResult(), JSONObject.class).map(Update::create).collect(Collectors.toList());
    }
}
