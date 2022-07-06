package ru.telegram.bot.goeventsmeeting.bot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("telegram.bot")
public class TelegramBotProperties {
    private String token;
    private String botname;
}

