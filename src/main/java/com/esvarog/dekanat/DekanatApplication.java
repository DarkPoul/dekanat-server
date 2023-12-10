package com.esvarog.dekanat;


import com.esvarog.dekanat.security.initializer.*;
import com.esvarog.dekanat.telegram_bot.TelegramBot;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@SpringBootApplication
public class DekanatApplication {
    private final DataInitializerUser dataInitializerUser;


    public DekanatApplication(DataInitializerUser dataInitializerUser) {

        this.dataInitializerUser = dataInitializerUser;
    }

    public static void main(String[] args) throws TelegramApiException {
        Dotenv dotenv = Dotenv.load();
        String botToken = dotenv.get("TELEGRAM_BOT_TOKEN");
//        String botToken = dotenv.get("TELEGRAM_BOT_TOKEN_DEV");
        String chatId = dotenv.get("TELEGRAM_CHAT_ID");

        File logFile = new File("bot.log");
        if (logFile.exists()) {
            logFile.delete();
        }
        TelegramBot telegramBot = new TelegramBot(); // Ініціалізуйте бота
        telegramBot.setChatId(chatId); // Встановіть chatId
        telegramBot.setToken(botToken); // Встановіть токен

        try {
            telegramBot.init();

            SpringApplication.run(DekanatApplication.class, args); // Запустіть сервер Spring
            telegramBot.sendTelegramMessage("Dekanat application started");
        } catch (Exception e) {
            telegramBot.sendTelegramMessage("Dekanat application failed to start");
            telegramBot.sendLogAfterError();
            throw e;
        }
    }


    @PostConstruct
    public void init() {
        this.dataInitializerUser.init();
    }
}
