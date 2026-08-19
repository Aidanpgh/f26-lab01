package edu.cmu.cs214.booking.domain;

/**
 * A user waiting for a room over a given interval, because it was taken when
 * they asked. {@code seq} is a global, increasing arrival order used to promote
 * waiters first-come-first-served.
 */
public record WaitlistEntry(String id, Room room, User user, TimeInterval interval, int seq) {
}
