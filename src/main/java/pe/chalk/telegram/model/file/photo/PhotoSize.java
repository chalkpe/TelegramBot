package pe.chalk.telegram.model.file.photo;

import pe.chalk.telegram.model.file.AbstractFile;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class PhotoSize extends AbstractFile {
    protected PhotoSize(final String id, final int size){
        super(id, size);
    }
}
