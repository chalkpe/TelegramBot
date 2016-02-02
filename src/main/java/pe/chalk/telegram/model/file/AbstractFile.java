package pe.chalk.telegram.model.file;

import pe.chalk.telegram.model.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class AbstractFile implements Identified<String> {
    private final String id;
    private final int size;

    protected AbstractFile(final String id, final int size){
        this.id = id;
        this.size = size;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getSize(){
        return this.size;
    }
}
