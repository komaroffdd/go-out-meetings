package ru.telegram.bot.goeventsmeeting.entity;

public record LocationEntity(int id, String metroStation, String street, String link,
                             String name, String phoneNumber, int averageCost,
                             String addInformation, String adminContact, String bonuses,
                             String status, int availableScheduleId) {
}
