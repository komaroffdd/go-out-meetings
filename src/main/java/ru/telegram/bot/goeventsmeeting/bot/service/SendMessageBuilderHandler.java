package ru.telegram.bot.goeventsmeeting.bot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
@Slf4j
@Service
public class SendMessageBuilderHandler {
    private final SendMessageBuilderService sendMessageBuilderService;

    public SendMessage handle(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            if (message.getText().equalsIgnoreCase("/start")) {
                return sendMessageBuilderService.build(chatId, "Добро пожаловать в нашего бота - выберите что вы хоиитет ");

            }
        }
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String chatId = callbackQuery.getMessage().getChatId().toString();
            return sendMessageBuilderService.build(chatId, "Вы кликнули на кнопку + " + callbackQuery.getData());
        }
        return null;
    }
}
