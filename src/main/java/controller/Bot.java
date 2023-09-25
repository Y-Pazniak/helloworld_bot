package controller;

import model.RandomPhraseSingleton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import view.TwoButtonsKeyboard;

public class Bot extends TelegramLongPollingBot {
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
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if ("/start".equals(update.getMessage().getText())) {
                    try {
                        SendMessage message = new SendMessage();
                        message.setChatId(update.getMessage().getChatId().toString());
                        message.setText("hallo");
                        message.setReplyMarkup(TwoButtonsKeyboard.getInstance());
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            try {
                SendMessage localMessage = new SendMessage();
                localMessage.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                localMessage.setText(RandomPhraseSingleton.getInstance().getPhrase());
                execute(localMessage);
                //execute(sendInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId())); //here is the problem: you must take chatId from the update.getCallbackQuery(), NOT from the update.getMessage()

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


