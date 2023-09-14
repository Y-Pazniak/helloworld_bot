package controller;

import model.RandomPhraseSingleton;
import model.Storage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import view.KeyboardMarkup;

public class Bot extends TelegramLongPollingBot {
    public void serve() {
    }

    @Override
    public String getBotUsername() {
        return "helloworld_eugene_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("EUGENE_TEST_TELEGRAM_BOT");
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage outMess = new SendMessage();
        sendKeyboardButtons(outMess, update.getMessage());
    }

    private void sendKeyboardButtons(SendMessage outMess, Message message) {
        outMess.setChatId(message.getChatId().toString());
        if (message.getText().equals("/start")) {
            outMess.setText(Storage.SAY_HELLO.getPhrase());
            outMess.setReplyMarkup(new KeyboardMarkup().getInstance());
        } else {
            outMess.setText(RandomPhraseSingleton.RandomPhraseSingletonHolder.getPhrase());
        }

        try {
            execute(outMess);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}


