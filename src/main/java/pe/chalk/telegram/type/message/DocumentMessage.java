package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.Document;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class DocumentMessage extends Message {
    private final Document document;
    private DocumentMessage(JSONObject json){
        super(json);
        this.document = Document.create(json.getJSONObject("document"));

    }

    public static DocumentMessage create(final JSONObject json){
        return new DocumentMessage(json);
    }

    public Document getDocument(){
        return this.document;
    }
}
