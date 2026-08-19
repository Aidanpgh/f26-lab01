package edu.cmu.cs214.booking.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TimeIntervalTest {

    @Test
    void overlapsWhenIntervalsIntersect() {
        assertTrue(new TimeInterval(600, 720).overlaps(new TimeInterval(660, 780)));
    }

    @Test
    void doesNotOverlapWhenDisjoint() {
        assertFalse(new TimeInterval(540, 600).overlaps(new TimeInterval(720, 780)));
    }

    @Test
    void touchingIntervalsDoNotOverlap() {
        assertFalse(new TimeInterval(600, 660).overlaps(new TimeInterval(660, 720)));
        assertFalse(new TimeInterval(660, 720).overlaps(new TimeInterval(600, 660)));
    }

    @Test
    void containedIntervalOverlaps() {
        assertTrue(new TimeInterval(540, 780).overlaps(new TimeInterval(600, 660)));
        assertTrue(new TimeInterval(600, 660).overlaps(new TimeInterval(540, 780)));
    }

    @Test
    void emptyIntervalIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new TimeInterval(600, 600));
    }
}
