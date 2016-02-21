package pe.chalk.telegram.type.file.media;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.photo.PhotoSize;
import pe.chalk.telegram.type.file.photo.Sized;
import pe.chalk.telegram.type.file.photo.Thumbnail;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Video extends MimeTypeFile implements Sized, Sound, Thumbnail {
    private final int width;
    private final int height;
    private final int duration;
    private final PhotoSize thumb;

    private Video(final JSONObject json){
        super(json);
        this.width    = json.getInt("width");
        this.height   = json.getInt("height");
        this.duration = json.getInt("duration");
        this.thumb    = json.has("thumb") ? PhotoSize.create(json.getJSONObject("thumb")) : null;
    }

    public static Video create(final JSONObject json){
        return new Video(json);
    }

    @Override
    public int getWidth(){
        return this.width;
    }

    @Override
    public int getHeight(){
        return this.height;
    }

    @Override
    public int getDuration(){
        return this.duration;
    }

    @Override
    public PhotoSize getThumb(){
        return this.thumb;
    }
}
