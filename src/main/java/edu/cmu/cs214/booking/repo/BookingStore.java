package edu.cmu.cs214.booking.repo;

import edu.cmu.cs214.booking.domain.Booking;
import edu.cmu.cs214.booking.domain.Room;
import edu.cmu.cs214.booking.domain.WaitlistEntry;
import java.util.List;
import java.util.Optional;

/**
 * The persistence seam for bookings and waitlist entries. The service depends on
 * this interface, not on any concrete storage. Today the only implementation is
 * in memory.
 */
public interface BookingStore {

    void addBooking(Booking booking);

    Optional<Booking> findBooking(String bookingId);

    /** The confirmed bookings held for {@code room}. */
    List<Booking> bookingsForRoom(Room room);

    List<Booking> allBookings();

    void removeBooking(String bookingId);

    void addWaitlistEntry(WaitlistEntry entry);

    /** The waitlist entries for {@code room}. */
    List<WaitlistEntry> waitlistForRoom(Room room);

    void removeWaitlistEntry(String waitlistId);
}
