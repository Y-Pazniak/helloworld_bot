package controller;

import model.RandomPhrase;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public void serve() {
    }

    @Override
    public String getBotUsername() {
        return "helloworld_eugene_bot";
    }

    @Override
    public String getBotToken() {
        return "6546426844:AAFuKQt1_phktU0EPGfmzeXAkPl-_B8ou_k";
    }

    @Override
    public void onUpdateReceived(Update update) {
        RandomPhrase randomPhrase = new RandomPhrase();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(randomPhrase.getPhrase());

        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
