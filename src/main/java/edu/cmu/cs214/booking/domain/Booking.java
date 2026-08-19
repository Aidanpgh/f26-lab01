package edu.cmu.cs214.booking.domain;

/** A confirmed booking: one user holds one room for one time interval. */
public record Booking(String id, Room room, User user, TimeInterval interval) {
}
