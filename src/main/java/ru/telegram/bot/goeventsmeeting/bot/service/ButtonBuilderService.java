package ru.telegram.bot.goeventsmeeting.bot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ButtonBuilderService {
    public InlineKeyboardMarkup inlineKeyboardMarkup() {

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
