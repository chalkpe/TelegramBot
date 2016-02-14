package pe.chalk.telegram.handler;

import pe.chalk.telegram.type.Response;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public interface MessageHandler {
    void handleMessage(Response response);
}
