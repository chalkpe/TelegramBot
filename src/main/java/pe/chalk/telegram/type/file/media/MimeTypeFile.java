package pe.chalk.telegram.type.file.media;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.BaseFile;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-21
 */
public abstract class MimeTypeFile extends BaseFile {
    private final String mimeType;
    protected MimeTypeFile(JSONObject json){
        super(json);
        this.mimeType = json.optString("mime_type");
    }

    public String getMimeType(){
        return this.mimeType;
    }
}
