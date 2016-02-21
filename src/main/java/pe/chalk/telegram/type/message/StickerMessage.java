package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.photo.Sticker;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class StickerMessage extends Message {
    private final Sticker sticker;
    private StickerMessage(JSONObject json){
        super(json);
        this.sticker = Sticker.create(json.getJSONObject("sticker"));
    }

    public static StickerMessage create(final JSONObject json){
        return new StickerMessage(json);
    }

    public Sticker getSticker(){
        return this.sticker;
    }
}