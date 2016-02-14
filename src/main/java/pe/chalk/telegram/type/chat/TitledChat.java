package pe.chalk.telegram.type.chat;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public abstract class TitledChat extends Chat {
    private final String title;

    protected TitledChat(final int id, final String type, final String title){
        super(id, type);
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
