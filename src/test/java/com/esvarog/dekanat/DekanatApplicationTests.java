package com.esvarog.dekanat;

import com.esvarog.dekanat.telegram_bot.TelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = DekanatApplication.class)
public class DekanatApplicationTests {
    @Test
    public void testSpringApplicationStartupThrowsException() throws TelegramApiException {
        TelegramBot telegramBot = new TelegramBot();
        telegramBot.setChatId("577428372");
        telegramBot.setToken("6610993356:AAFFPDBXevDcNCcfoS1RsFup5vqzRuNcOd0");
        telegramBot.init();

        // Затримка для тесту
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // обробка винятку при затримці
            e.printStackTrace();
        }

        // Звідси починаємо ловити виняток
        try {
            SpringApplication.run(DekanatApplication.class);
            telegramBot.sendTelegramMessage("Dekanat application started");
        } catch (Exception e) {
            // Очікуваний виняток
            e.printStackTrace();
        }
    }

}

