package pe.chalk.telegram.type.file;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Video extends AbstractFile {
    private Video(final JSONObject json){
        super(json);
    }

    public static Video create(final JSONObject json){
        return new Video(json);
    }
}
