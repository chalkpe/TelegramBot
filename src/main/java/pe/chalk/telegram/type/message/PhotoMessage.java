package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.photo.Photo;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class PhotoMessage extends CaptionedMessage {
    private final Photo photo;
    private PhotoMessage(JSONObject json){
        super(json);
        this.photo = Photo.create(json.getJSONArray("photo"));
    }

    public static PhotoMessage create(final JSONObject json){
        return new PhotoMessage(json);
    }

    public Photo getPhoto(){
        return this.photo;
    }
}
