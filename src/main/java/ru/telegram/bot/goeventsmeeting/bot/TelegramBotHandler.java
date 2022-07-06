package ru.telegram.bot.goeventsmeeting.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TelegramBotHandler extends TelegramLongPollingBot {
    private final TelegramBotProperties telegramBotProperties;

    @Override
    public String getBotUsername() {
        return telegramBotProperties.getBotname();
    }

    @Override
    public String getBotToken() {
        return telegramBotProperties.getToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        /* todo
         * Стуктура хранения кнопок в зависимости от роли и превАктион
         * Фабрика над контентом SendPhoto SendMessage
         * Разобраться как отправлять уведомления
         *  */
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.getText().equalsIgnoreCase("/start")) {
                execute(generateSendMessage(message, "Добро пожаловать в нашего бота - выберите что вы хоиитет "));
            }
        }
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            execute(generateSendMessage(callbackQuery.getMessage(), "Вы кликнули на кнопку + " + callbackQuery.getData()));
        }
    }

    private SendMessage generateSendMessage(Message messageObject, String message) {

        return SendMessage.builder()
                .chatId(messageObject.getChatId().toString())
                .text(message)
                .replyMarkup(inlineKeyboardMarkup())
                .build();
    }

    private InlineKeyboardMarkup inlineKeyboardMarkup() {

        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .callbackData("BUTTON-1")
                                .text("BUTTON-1")
                                .build()
                ))
                .keyboardRow(List.of(InlineKeyboardButton.builder()
                        .callbackData("BUTTON-2")
                        .text("BUTTON-2")
                        .build()))
                .build();
    }
}
