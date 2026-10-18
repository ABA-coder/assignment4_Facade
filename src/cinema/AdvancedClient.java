package cinema;

public class AdvancedClient {
    public static void main(String[] args) {
        ShowtimeCatalog catalog = new ShowtimeCatalog();
        SeatManager seats = new SeatManager();
        PaymentService payments = new PaymentService();
        TicketPrinter printer = new TicketPrinter();

        String showId = "S2";
        String seat = "A2";
        String userId = "U1";
        String movie = catalog.movieFor(showId);
        int price = catalog.priceFor(showId);
        seats.reserve(showId, seat);
        boolean paid = false;
        try {
            payments.charge(userId, price);
            paid = true;
            System.out.println(printer.printTicket(userId, movie, showId, seat));
        } catch (RuntimeException error) {
            if (paid) {
                payments.refund(userId, price);
            }
            seats.release(showId, seat);
            throw error;
        }
    }
}
