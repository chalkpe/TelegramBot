package pe.chalk.telegram;

import org.junit.Test;
import pe.chalk.telegram.type.message.Message;
import pe.chalk.telegram.type.message.TextMessage;
import pe.chalk.telegram.type.user.User;
import pe.chalk.telegram.util.MessageOption;
import pe.chalk.telegram.util.ParseMode;

import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

import static org.junit.Assert.*;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-15
 */
public class TelegramBotTest {
    private final String token = System.getenv("TelegramBotToken");
    private final TelegramBot bot;

    public TelegramBotTest(){
        bot = new TelegramBot(token);

        Logger.getLogger("TelegramBot").setUseParentHandlers(false);
        for(final Handler handler: Logger.getLogger("TelegramBot").getHandlers()) Logger.getLogger("TelegramBot").removeHandler(handler);

        final ConsoleHandler handler = new ConsoleHandler(){
            @Override
            protected synchronized void setOutputStream(final OutputStream out) throws SecurityException {
                super.setOutputStream(System.out);
            }
        };
        handler.setLevel(Level.FINER);

        Logger.getLogger("TelegramBot").setLevel(handler.getLevel());
        Logger.getLogger("TelegramBot").addHandler(handler);
    }

    @Test
    public void testToken(){
        assertNotNull(bot); assertNotNull(token);
        assertEquals(token, bot.getToken());
    }

    @Test
    public void testMe(){
        final User me = bot.getMe();
        assertNotNull(me);

        assertTrue(me.getUsername().toLowerCase().endsWith("bot"));
        assertEquals(me.getFirstName(), "Chalk (bot)");
        assertNull(me.getLastName());
    }

    @Test
    public void testRunning() throws Exception {
        final CompletableFuture<TextMessage> future = new CompletableFuture<>();
        bot.addHandler(updates -> updates.forEach(update -> {
            final Message message = update.getMessage();
            if(Objects.isNull(message) || !(message instanceof TextMessage)) return;

            final TextMessage textMessage = (TextMessage) message;
            Logger.getLogger("TelegramBot").info(String.format("[%d] %s - %s%n", message.getChat().getId(), message.getId(), textMessage.getText()));

            if(textMessage.getText().startsWith("@Test ")) future.complete(textMessage);
        }));

        assertFalse(bot.getHandlers().isEmpty());
        bot.start();

        final TextMessage textMessage = future.get(1, TimeUnit.MINUTES);
        assertEquals("@Test hello!", textMessage.getText());

        final int chatId = textMessage.getChat().getId();
        final String reply = String.format("\\[%d] Hi, *%d*!", chatId, textMessage.getId());

        final Message sentMessage = bot.sendMessage(new MessageOption(chatId, reply).parseMode(ParseMode.MARKDOWN).replyToMessage(textMessage));
        assertEquals((long) chatId, (long) sentMessage.getChat().getId());
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread.sleep(2000);

        bot.interrupt();
        assertFalse("Thread dead", bot.isAlive());
    }
}