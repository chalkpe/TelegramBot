package pe.chalk.telegram.type.chat;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Supergroup extends Group {
    protected Supergroup(final int id, final String title){
        super(id, Type.SUPERGROUP, title);
    }
}
