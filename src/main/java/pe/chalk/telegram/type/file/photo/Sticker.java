package pe.chalk.telegram.type.file.photo;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.AbstractFile;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Sticker extends AbstractFile {
    private Sticker(final JSONObject json){
        super(json);
    }

    public static Sticker create(final JSONObject json){
        return new Sticker(json);
    }
}
