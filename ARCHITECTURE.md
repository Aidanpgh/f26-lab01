# Architecture

A small room-booking service in three layers. Read this before the code; it will
save you cold-reading every file.

```
domain/   the data and the rules, no I/O
service/  orchestrates a booking request
repo/     stores bookings and waitlist entries (the persistence seam)
```

## Domain (`edu.cmu.cs214.booking.domain`)

- `TimeInterval`: a half-open interval `[start, end)` in minutes since midnight. Its
  `overlaps` method is the one place the "do these two clash?" rule lives.
- `Room`: an id, a name, and a capacity (capacity is unused for now).
- `User`: an id and a name.
- `Booking`: a confirmed booking, one user holding a room for an interval.
- `WaitlistEntry`: a user waiting for a room over an interval, with an arrival order
  (`seq`) so waiters can be served first-come-first-served.

## Service (`edu.cmu.cs214.booking.service`)

- `BookingService.book(room, user, interval)`: the heart of the system. It asks the
  store for the room's bookings, checks each for an overlap, and either confirms the
  booking or puts the user on the room's waitlist.
- `BookingResult`: the outcome, either `Confirmed(booking)` or `Waitlisted(position)`.

The core invariant (i.e., a property that must be true at all times before and after the
execution of a public method) the service protects:
**a room never holds two confirmed bookings whose intervals overlap.**

## Repository (`edu.cmu.cs214.booking.repo`)

- `BookingStore`: the interface the service depends on. It stores and retrieves
  bookings and waitlist entries.
- `InMemoryBookingStore`: the only implementation today, backed by in-memory lists.

## The flow of a booking

1. `BookingService.book` asks the store for the room's existing bookings.
2. If any overlaps the requested interval, the user is added to the waitlist.
3. Otherwise a `Booking` is created and saved, and the result is `Confirmed`.

Waitlist entries accumulate but are not yet promoted anywhere. Promotion is what
you will implement in Milestone 2.
