package cinema;

public class CinemaTicketFacade {
    private final ShowtimeCatalog catalog = new ShowtimeCatalog();
    private final SeatManager seats = new SeatManager();
    private final PaymentService payments = new PaymentService();
    private final TicketPrinter printer = new TicketPrinter();

    public String buyTicket(String userId, String showId, String seat) {
        String movie = catalog.movieFor(showId);
        int price = catalog.priceFor(showId);
        seats.reserve(showId, seat);

        boolean paid = false;
        try {
            payments.charge(userId, price);
            paid = true;
            return printer.printTicket(userId, movie, showId, seat);
        } catch (RuntimeException error) {
            if (paid) {
                payments.refund(userId, price);
            }
            seats.release(showId, seat);
            throw error;
        }
    }
}
