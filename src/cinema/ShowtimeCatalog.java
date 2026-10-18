package cinema;

import java.util.Map;

public class ShowtimeCatalog {
    private final Map<String, String> movies = Map.of(
            "S1", "Moon Mission", "S2", "Ocean Life");
    private final Map<String, Integer> prices = Map.of(
            "S1", 1200, "S2", 900);

    public String movieFor(String showId) {
        checkShow(showId);
        return movies.get(showId);
    }

    public int priceFor(String showId) {
        checkShow(showId);
        return prices.get(showId);
    }

    private void checkShow(String showId) {
        if (showId == null || !movies.containsKey(showId)) {
            throw new IllegalArgumentException("Unknown showtime: " + showId);
        }
    }
}
