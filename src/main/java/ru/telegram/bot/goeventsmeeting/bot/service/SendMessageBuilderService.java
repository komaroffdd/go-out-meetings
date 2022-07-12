package ru.telegram.bot.goeventsmeeting.bot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@RequiredArgsConstructor
@Slf4j
@Service
public class SendMessageBuilderService {
    private final ButtonBuilderService buttonBuilderService;

    public SendMessage build(String chatId, String message) {

        return SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .replyMarkup(buttonBuilderService.inlineKeyboardMarkup())
                .build();
    }
}
