package pe.chalk.telegram.type.file;

import org.json.JSONObject;
import pe.chalk.telegram.type.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class BaseFile implements Identified<String> {
    private final String id;
    private final int size;

    protected BaseFile(final JSONObject json){
        this.id   = json.getString("file_id");
        this.size = json.getInt("file_size");
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getSize(){
        return this.size;
    }
}
