package pe.chalk.telegram.type.file;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.media.MimeTypeFile;
import pe.chalk.telegram.type.file.photo.PhotoSize;
import pe.chalk.telegram.type.file.photo.Thumbnail;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Document extends MimeTypeFile implements Thumbnail {
    private final PhotoSize thumb;
    private final String filename;

    private Document(final JSONObject json){
        super(json);
        this.thumb    = json.has("thumb") ? PhotoSize.create(json.getJSONObject("thumb")) : null;
        this.filename = json.optString("file_name", null);
    }

    public static Document create(final JSONObject json){
        return new Document(json);
    }

    @Override
    public PhotoSize getThumb(){
        return this.thumb;
    }

    public String getFilename(){
        return this.filename;
    }
}
