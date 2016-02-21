package pe.chalk.telegram.type.user;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public interface Named {
    String getFirstName();
    String getLastName();

    default String getFullName(){
        return this.getFirstName() + (Objects.isNull(this.getLastName()) ? "" : " " + this.getLastName());
    }
}
