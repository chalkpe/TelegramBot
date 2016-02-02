package pe.chalk.telegram.model.file;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-03
 */
public class File extends AbstractFile {
    private final String path;

    private File(final String id, final int size, final String path){
        super(id, size);
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
