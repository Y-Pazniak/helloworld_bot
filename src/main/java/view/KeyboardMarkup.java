package view;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardMarkup {

    public KeyboardMarkup() {
    }

    public SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup keyboardWithButtons = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("button 1");
        inlineKeyboardButton1.setCallbackData("button 1");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("button 2");
        inlineKeyboardButton2.setCallbackData("button 2");

        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        rowsInline.add(rowInline1);
        keyboardWithButtons.setKeyboard(rowsInline);

        SendMessage message = new SendMessage();
        message.setChatId(chatId + "");
        message.setText("hallo");
        message.setReplyMarkup(keyboardWithButtons);

        return message;
    }

}
