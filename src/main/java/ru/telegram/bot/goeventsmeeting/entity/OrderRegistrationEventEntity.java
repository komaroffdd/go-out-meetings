package ru.telegram.bot.goeventsmeeting.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record OrderRegistrationEventEntity(int id, int userId, String role, String eventId) {
}
