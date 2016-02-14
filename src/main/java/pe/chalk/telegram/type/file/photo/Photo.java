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
