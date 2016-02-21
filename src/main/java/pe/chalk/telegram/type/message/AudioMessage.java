package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.media.Audio;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class AudioMessage extends Message {
    private final Audio audio;
    private AudioMessage(JSONObject json){
        super(json);
        this.audio = Audio.create(json.getJSONObject("audio"));
    }

    public static AudioMessage create(final JSONObject json){
        return new AudioMessage(json);
    }

    public Audio getAudio(){
        return this.audio;
    }
}
