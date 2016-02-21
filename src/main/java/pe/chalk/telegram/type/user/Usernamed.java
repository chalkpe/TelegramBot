package pe.chalk.telegram.type.user;

import java.util.Objects;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public interface Usernamed {
    String getUsername();

    default boolean hasUsername(){
        return Objects.nonNull(this.getUsername());
    }
}
