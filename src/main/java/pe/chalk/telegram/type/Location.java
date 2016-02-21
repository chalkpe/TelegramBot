package pe.chalk.telegram.type;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Location {
    private final double longitude;
    private final double latitude;

    private Location(final JSONObject json){
        this.longitude = json.getDouble("longitude");
        this.latitude  = json.getDouble("latitude");
    }

    public static Location create(final JSONObject json){
        return new Location(json);
    }

    public double getLongitude(){
        return this.longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }
}
