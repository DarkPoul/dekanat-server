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
    private final DataInitializerAssessment dataInitializerAssessment;
    private final DataInitializerDepartment dataInitializerDepartment;
    private final DataInitializerEduDoc dataInitializerEduDoc;
    private final DataInitializerFaculty dataInitializerFaculty;
    private final DataInitializerGroup dataInitializerGroup;
    private final DataInitializerOrder dataInitializerOrder;
    private final DataInitializerRegion dataInitializerRegion;
    private final DataInitializerUser dataInitializerUser;


    public DekanatApplication(DataInitializerAssessment dataInitializerAssessment, DataInitializerDepartment dataInitializerDepartment, DataInitializerEduDoc dataInitializerEduDoc, DataInitializerFaculty dataInitializerFaculty, DataInitializerGroup dataInitializerGroup, DataInitializerOrder dataInitializerOrder, DataInitializerRegion dataInitializerRegion, DataInitializerUser dataInitializerUser) {
        this.dataInitializerAssessment = dataInitializerAssessment;
        this.dataInitializerDepartment = dataInitializerDepartment;
        this.dataInitializerEduDoc = dataInitializerEduDoc;
        this.dataInitializerFaculty = dataInitializerFaculty;
        this.dataInitializerGroup = dataInitializerGroup;
        this.dataInitializerOrder = dataInitializerOrder;
        this.dataInitializerRegion = dataInitializerRegion;
        this.dataInitializerUser = dataInitializerUser;
    }

    public static void main(String[] args) throws TelegramApiException {
        Dotenv dotenv = Dotenv.load();
        String botToken = dotenv.get("TELEGRAM_BOT_TOKEN");
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
        this.dataInitializerAssessment.init();
        this.dataInitializerDepartment.init();
        this.dataInitializerEduDoc.init();
        this.dataInitializerFaculty.init();
        this.dataInitializerGroup.init();
        this.dataInitializerOrder.init();
        this.dataInitializerRegion.init();
        this.dataInitializerUser.init();
    }
}
