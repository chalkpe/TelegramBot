package pe.chalk.telegram.model.user;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public interface Named {
    String getFirstName();
    String getLastName();

    default String getFullName(){
        return this.getFirstName() + (this.getLastName() == null ? "" : " " + this.getLastName());
    }
}
