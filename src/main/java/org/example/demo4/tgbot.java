package org.example.demo4;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

class MyBot extends TelegramLongPollingBot {

    private final Randomizer randomizer = new Randomizer();
    private final ChuckJoke chuckJoke = new ChuckJoke();
    private final Photos photos = new Photos();

    @Override
    public void onUpdateReceived(Update update) {
        long chatId;

        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
            sendActionMessage(chatId);
        }

        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            handleRandomAction(chatId);
        }
    }

    private void sendActionMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Нажми кнопку, чтобы сгенерировать число:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        InlineKeyboardButton button = new InlineKeyboardButton("🎲 Генерировать");
        button.setCallbackData("generate");

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);
        markup.setKeyboard(rows);

        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void handleRandomAction(long chatId) {
        int result = randomizer.generate();

        if (result == 0) {
            String joke = chuckJoke.getRandomChuckJoke();
            sendText(chatId, joke);
        } else {
            File img = photos.getRandomInternetImageAsFile();
            if (img != null) {
                sendPhoto(chatId, img);
            } else {
                sendText(chatId, "Не удалось загрузить изображение.");
            }
        }

        sendActionMessage(chatId);
    }

    private void sendText(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto(long chatId, File imageFile) {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile(imageFile));
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "eshchkereee_bot";
    }

    @Override
    public String getBotToken() {
        return "7822822673:AAGGs-Rmb7IE67eM91mqmB2vJTmszr7zcFo";
    }
}
