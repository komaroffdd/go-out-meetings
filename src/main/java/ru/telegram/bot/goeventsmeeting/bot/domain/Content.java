package ru.telegram.bot.goeventsmeeting.bot.domain;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

public record Content(SendMessage sendMessage, SendPhoto sendPhoto) {
}
