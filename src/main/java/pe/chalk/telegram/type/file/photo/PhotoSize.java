package pe.chalk.telegram.type.file.photo;

import org.json.JSONObject;
import pe.chalk.telegram.type.file.BaseFile;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class PhotoSize extends BaseFile implements Sized {
    private final int width;
    private final int height;

    protected PhotoSize(final JSONObject json){
        super(json);
        this.width  = json.getInt("width");
        this.height = json.getInt("height");
    }

    public static PhotoSize create(final JSONObject json){
        return new PhotoSize(json);
    }

    @Override
    public int getWidth(){
        return this.width;
    }

    @Override
    public int getHeight(){
        return this.height;
    }
}
