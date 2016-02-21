package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.Location;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class LocationMessage extends Message {
    private final Location location;
    private LocationMessage(JSONObject json){
        super(json);
        this.location = Location.create(json.getJSONObject("location"));
    }

    public static LocationMessage create(final JSONObject json){
        return new LocationMessage(json);
    }

    public Location getLocation(){
        return this.location;
    }
}