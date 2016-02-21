package pe.chalk.telegram.type.file.media;

import org.json.JSONObject;
import pe.chalk.telegram.type.Titled;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Audio extends MimeTypeFile implements Titled, Sound {
    private final int duration;
    private final String performer;
    private final String title;

    private Audio(final JSONObject json){
        super(json);
        this.duration  = json.getInt("duration");
        this.performer = json.optString("performer", null);
        this.title     = json.optString("title", null);
    }

    public static Audio create(final JSONObject json){
        return new Audio(json);
    }

    @Override
    public int getDuration(){
        return this.duration;
    }

    public String getPerformer(){
        return this.performer;
    }

    @Override
    public String getTitle(){
        return this.title;
    }
}
