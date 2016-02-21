package pe.chalk.telegram.type.file.photo;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Sticker extends PhotoSize implements Thumbnail {
    private final PhotoSize thumb;
    private Sticker(final JSONObject json){
        super(json);
        this.thumb = json.has("thumb") ? PhotoSize.create(json.getJSONObject("thumb")) : null;
    }

    public static Sticker create(final JSONObject json){
        return new Sticker(json);
    }

    @Override
    public PhotoSize getThumb(){
        return this.thumb;
    }
}
