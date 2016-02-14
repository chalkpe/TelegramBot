package pe.chalk.telegram.type.file;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class File extends AbstractFile {
    private final String path;

    private File(final JSONObject json){
        super(json);
        this.path = json.getString("file_path");
    }

    public static File create(final JSONObject json){
        return new File(json);
    }

    public String getPath(){
        return this.path;
    }
}
