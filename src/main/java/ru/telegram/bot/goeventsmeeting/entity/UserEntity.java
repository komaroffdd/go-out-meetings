package ru.telegram.bot.goeventsmeeting.entity;

import java.sql.Timestamp;

public record UserEntity(int id, int age, String name, String telegramUsername,
                         String socialLinks, String interests, String role,
                         String donatLink, Timestamp created, Timestamp updated) {
}
