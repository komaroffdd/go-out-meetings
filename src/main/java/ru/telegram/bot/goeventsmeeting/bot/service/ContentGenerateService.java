package ru.telegram.bot.goeventsmeeting.bot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.goeventsmeeting.bot.domain.Content;

@RequiredArgsConstructor
@Slf4j
@Service
public class ContentGenerateService {
    private final SendMessageBuilderHandler sendMessageBuilderHandler;

    public Content getContent(Update update) {
        SendMessage sendMessage = sendMessageBuilderHandler.handle(update);
        return new Content(sendMessage,null);
    }

}
