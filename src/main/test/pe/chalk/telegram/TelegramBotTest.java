package pe.chalk.telegram;

import org.junit.Test;
import pe.chalk.telegram.type.message.Message;
import pe.chalk.telegram.type.message.TextMessage;
import pe.chalk.telegram.type.user.User;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-15
 */
public class TelegramBotTest {
    private final String token = System.getenv("TelegramBotToken");
    private TelegramBot bot;

    public TelegramBotTest(){
        bot = new TelegramBot(token);
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

        assertEquals(me.getId(), 151600933);
        assertEquals(me.getUsername(), "ChalkBot");
        assertEquals(me.getFirstName(), "Chalk (bot)");
        assertNull(me.getLastName());
    }

    @Test
    public void testRunning() throws Exception {
        final CompletableFuture<String> future = new CompletableFuture<>();

        bot.addHandler(updates -> updates.forEach(update -> {
            final Message message = update.getMessage();
            if(message != null && message instanceof TextMessage){
                final TextMessage textMessage = (TextMessage) message;
                System.out.printf("[%d] %s - %s%n", message.getChat().getId(), message.getId(), textMessage.getText());

                if(textMessage.getText().startsWith("@Test ")) future.complete(textMessage.getText());
            }
        }));

        bot.start();
        assertEquals("@Test hello!", future.get(1, TimeUnit.MINUTES));
    }

    @Test
    public void testInterrupt(){
        bot.interrupt();
        assertFalse("Thread dead", bot.isAlive());
    }
}