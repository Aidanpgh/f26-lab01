package edu.cmu.cs214.booking.service;

import edu.cmu.cs214.booking.domain.Booking;

/** The outcome of a booking attempt: either confirmed, or placed on the waitlist. */
public sealed interface BookingResult {

    /** The room was free; the booking is confirmed. */
    record Confirmed(Booking booking) implements BookingResult {
    }

    /** The room was taken; the user was placed on the waitlist at {@code position}. */
    record Waitlisted(int position) implements BookingResult {
    }
}
