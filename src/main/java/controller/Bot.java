package controller;

import model.RandomPhraseSingleton;
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
        return System.getenv("EUGENE_TEST_TELEGRAM_BOT");
    }

    @Override
    public void onUpdateReceived(Update update) {
        RandomPhraseSingleton.RandomPhraseSingletonHolder randomPhrase = RandomPhraseSingleton.getInstance();
        sendText(update.getMessage().getChatId(), randomPhrase.getPhrase());
    }

    public void sendText(Long who, String what) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
