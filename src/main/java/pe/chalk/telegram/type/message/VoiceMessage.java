package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.media.Voice;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class VoiceMessage extends Message {
    private final Voice voice;
    private VoiceMessage(JSONObject json){
        super(json);
        this.voice = Voice.create(json.getJSONObject("voice"));

    }

    public static VoiceMessage create(final JSONObject json){
        return new VoiceMessage(json);
    }

    public Voice getVoice(){
        return this.voice;
    }
}