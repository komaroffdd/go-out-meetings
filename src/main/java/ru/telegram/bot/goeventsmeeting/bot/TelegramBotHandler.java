package ru.telegram.bot.goeventsmeeting.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.goeventsmeeting.bot.domain.Content;
import ru.telegram.bot.goeventsmeeting.bot.service.ContentGenerateService;

@RequiredArgsConstructor
@Slf4j
@Service
public class TelegramBotHandler extends TelegramLongPollingBot {
    private final TelegramBotProperties telegramBotProperties;
    private final ContentGenerateService contentGenerateService;

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
        Content content = contentGenerateService.getContent(update);
        if (content != null) {
            log.debug("Content not null:{}", content);
            SendMessage sendMessage = content.sendMessage();
            if (sendMessage != null) {
                log.debug("SendMessage not null:{}", sendMessage);
                execute(sendMessage);
            } else {
                log.debug("SendMessage is null");
                SendPhoto sendPhoto = content.sendPhoto();
                if (sendPhoto != null) {
                    log.debug("SendPhoto not null:{}", sendPhoto);
                    execute(sendPhoto);
                }
                log.warn("SendPhoto is null");
            }
        }
        log.warn("Content is null");
    }
}
