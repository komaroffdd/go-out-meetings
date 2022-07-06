package ru.telegram.bot.goeventsmeeting.entity;

import java.sql.Date;
import java.sql.Time;

public record EventEntity(int id, String name, boolean hasHeadliner, String topic,
                          String tags, int headlinerId, int locationId, String status,
                          String canceledReason, Date startDate, Time startTime,
                          int durationMinutes) {
}
