package ru.telegram.bot.goeventsmeeting.entity;

public record EventUserStatus(int userId, int eventId, String currentUserStatus, int userPosition) {
}
