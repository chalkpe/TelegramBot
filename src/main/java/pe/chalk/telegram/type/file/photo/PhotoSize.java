package pe.chalk.telegram.type.file.photo;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.AbstractFile;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class PhotoSize extends AbstractFile {
    private PhotoSize(final JSONObject json){
        super(json);
    }

    public static PhotoSize create(final JSONObject json){
        return new PhotoSize(json);
    }
}
