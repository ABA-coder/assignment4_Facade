package cinema;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatManager {
    private final Set<String> allSeats = Set.of("A1", "A2");
    private final Map<String, Set<String>> freeSeats = new HashMap<>();

    public SeatManager() {
        freeSeats.put("S1", new HashSet<>(allSeats));
        freeSeats.put("S2", new HashSet<>(allSeats));
    }

    public void reserve(String showId, String seat) {
        Set<String> seats = freeSeats.get(showId);
        if (seats == null || !seats.remove(seat)) {
            throw new IllegalStateException("Seat is unknown or busy: " + seat);
        }
    }

    public void release(String showId, String seat) {
        Set<String> seats = freeSeats.get(showId);
        if (seats == null || !allSeats.contains(seat) || !seats.add(seat)) {
            throw new IllegalStateException("Seat was not reserved: " + seat);
        }
    }

    public boolean isFree(String showId, String seat) {
        Set<String> seats = freeSeats.get(showId);
        return seats != null && seats.contains(seat);
    }
}
