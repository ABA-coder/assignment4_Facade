package cinema;

import java.util.ArrayList;
import java.util.List;

public class TicketPrinter {
    private final List<String> issuedTickets = new ArrayList<>();

    public String printTicket(String userId, String movie, String showId, String seat) {
        String ticket = "T" + (issuedTickets.size() + 1) + " | " + movie
                + " | show " + showId + " | seat " + seat + " | user " + userId;
        issuedTickets.add(ticket);
        return ticket;
    }

    public int issuedCount() {
        return issuedTickets.size();
    }
}
