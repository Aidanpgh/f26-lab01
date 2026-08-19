package edu.cmu.cs214.booking.domain;

/**
 * A bookable room. {@code capacity} is part of the model for a future feature
 * and is not used by the calendar yet.
 */
public record Room(String id, String name, int capacity) {
}
