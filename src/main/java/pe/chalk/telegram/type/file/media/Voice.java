package pe.chalk.telegram.type.file.media;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Voice extends MimeTypeFile implements Sound {
    private final int duration;
    public Voice(JSONObject json){
        super(json);
        this.duration = json.getInt("duration");
    }

    public static Voice create(final JSONObject json){
        return new Voice(json);
    }

    @Override
    public int getDuration(){
        return this.duration;
    }
}
