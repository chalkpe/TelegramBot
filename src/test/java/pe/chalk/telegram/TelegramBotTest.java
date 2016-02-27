/*
 * Copyright (C) 2016  ChalkPE
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pe.chalk.telegram;

import org.junit.Test;
import pe.chalk.telegram.method.MeGetter;
import pe.chalk.telegram.type.chat.TitledChat;
import pe.chalk.telegram.type.message.Message;
import pe.chalk.telegram.type.message.TextMessage;
import pe.chalk.telegram.type.user.User;
import pe.chalk.telegram.method.TextMessageSender;
import pe.chalk.telegram.util.ParseMode;

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

    private Logger logger;
    public TelegramBotTest(){
        bot = new TelegramBot(token);
        logger = bot.initLogger(Level.ALL);
    }

    @Test
    public void testToken(){
        assertNotNull(bot); assertNotNull(token);
        assertEquals(token, bot.getToken());
    }

    @Test
    public void testMe(){
        final User me = new MeGetter().get(bot);
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
            logger.info(String.format("[%d] [%d]%s%s%s%n",
                    message.getId(),
                    message.getChat().getId(),
                    (message.getChat() instanceof TitledChat) ? (" " + ((TitledChat) message.getChat()).getTitle() + " ") : " ",
                    message.hasFrom() ? (" [" + message.getFrom().getId() + "] " + message.getFrom().getFullName() + (message.getFrom().hasUsername() ? " (@" + message.getFrom().getUsername() + ")" : " ") + " - ") : " ",
                    textMessage.getText())
            );

            if(textMessage.getText().startsWith("@Test ")) future.complete(textMessage);
        }));

        assertFalse(bot.getHandlers().isEmpty());
        bot.start();

        final TextMessage textMessage = future.get(1, TimeUnit.MINUTES);
        assertEquals("@Test hello!", textMessage.getText());

        final int chatId = textMessage.getChat().getId();
        final String reply = String.format("<b>[%d]</b> <a href=\"https://github.com/ChalkPE/TelegramBot\">Test</a> <i>passed!</i>\n\n%s%s%sI'm on <b>%d</b>%s.",
                textMessage.getId(),
                textMessage.hasFrom() ? ("Hi, <b>" + encodeHTMLEntities(textMessage.getFrom().getFullName()) + "</b>") : "",
                (textMessage.hasFrom() && textMessage.getFrom().hasUsername()) ? (", who username is <b>@" + encodeHTMLEntities(textMessage.getFrom().getUsername()) + "</b>") : "",
                textMessage.hasFrom() ? "!\n" : "",
                textMessage.getChat().getId(),
                (textMessage.getChat() instanceof TitledChat) ? (", where the title is <b>" + encodeHTMLEntities(((TitledChat) textMessage.getChat()).getTitle()) + "</b>") : "");

        final Message sentMessage = new TextMessageSender(chatId, reply).parseMode(ParseMode.HTML).replyToMessage(textMessage).disableWebPagePreview(true).send(bot);
        assertEquals((long) chatId, (long) sentMessage.getChat().getId());
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        bot.interrupt();

        Thread.sleep(2000);
        assertFalse("Thread dead", bot.isAlive());
    }

    public String encodeHTMLEntities(final String str){
        return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
    }
}