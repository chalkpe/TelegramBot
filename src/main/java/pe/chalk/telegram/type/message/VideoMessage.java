package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.media.Video;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class VideoMessage extends CaptionedMessage {
    private final Video video;
    private VideoMessage(JSONObject json){
        super(json);
        this.video = Video.create(json.getJSONObject("video"));

    }

    public static VideoMessage create(final JSONObject json){
        return new VideoMessage(json);
    }

    public Video getVideo(){
        return this.video;
    }
}