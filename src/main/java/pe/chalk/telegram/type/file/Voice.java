package pe.chalk.telegram.type.file;

import org.json.JSONObject;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Voice extends AbstractFile {
    private Voice(final JSONObject json){
        super(json);
    }

    public static Voice create(final JSONObject json){
        return new Voice(json);
    }
}
