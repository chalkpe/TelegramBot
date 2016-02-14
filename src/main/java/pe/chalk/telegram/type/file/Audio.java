package pe.chalk.telegram.type.file;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Audio extends AbstractFile {
    private Audio(final JSONObject json){
        super(json);
    }

    public static Audio create(final JSONObject json){
        return new Audio(json);
    }
}
