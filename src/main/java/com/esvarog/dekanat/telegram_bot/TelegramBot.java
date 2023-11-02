package com.esvarog.dekanat.telegram_bot;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.util.ArrayList;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    String bot_token;

    @Value("${bot.chatId}")
    String chatId;

    public void sendTelegramMessage(String message) {
        try {
            execute(SendMessage.builder()
                    .chatId(chatId)
                    .text(message)
                    .build());
        } catch (TelegramApiException e) {
            e.fillInStackTrace();
        }
    }

    public void sendLogAfterError(){
        try {
            execute(SendDocument.builder()
                    .chatId(chatId)
                    .document(new InputFile(new File("bot.log")))
                    .build());
        } catch (TelegramApiException e){
            e.fillInStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            if (update.getMessage().getText().equals("/start")) {
                message.setChatId(chatId);
                message.setText("Це бот для логів деканату");

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setResizeKeyboard(true);
                replyKeyboardMarkup.setOneTimeKeyboard(false);

                ArrayList<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow keyboardRow = new KeyboardRow();
                keyboardRow.add("Показати логи");
                keyboard.add(keyboardRow);
                replyKeyboardMarkup.setKeyboard(keyboard);

                message.setReplyMarkup(replyKeyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.fillInStackTrace();
                }
            }
            else if (update.getMessage().getText().equals("Показати логи")) {
                SendDocument sendDocument = new SendDocument();
                sendDocument.setChatId(chatId);
                sendDocument.setDocument(new InputFile(new File("bot.log")));

                try {
                    execute(sendDocument);
                } catch (TelegramApiException e) {
                    e.fillInStackTrace();
                }
            }
            else {
                message.setChatId(chatId);
                message.setText("Я не розумію тебе");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.fillInStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "DekanatBot";
    }
    @Override
    public String getBotToken() {
        return bot_token;
    }

    public void init() throws TelegramApiException {
        // Ініціалізація бота
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(this); // Реєстрація бота
        } catch (TelegramApiRequestException e) {
            e.fillInStackTrace();
        }
    }

    public void setChatId(String chatId) {
        // Встановлення chatId
        this.chatId = chatId;
    }

    public void setToken(String token) {
        // Встановлення токену
        this.bot_token = token;
    }

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }
}

