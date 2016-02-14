package pe.chalk.telegram.type;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Location {
    private final float longitude;
    private final float latitude;

    private Location(final float longitude, final float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude(){
        return this.longitude;
    }

    public float getLatitude(){
        return this.latitude;
    }
}
