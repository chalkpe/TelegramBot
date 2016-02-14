package pe.chalk.telegram.type.file;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Document extends AbstractFile {
    private Document(final JSONObject json){
        super(json);
    }

    public static Document create(final JSONObject json){
        return new Document(json);
    }
}
