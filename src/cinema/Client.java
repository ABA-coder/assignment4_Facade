package cinema;

public class Client {
    public static void main(String[] args) {
        CinemaTicketFacade cinema = new CinemaTicketFacade();
        String ticket = cinema.buyTicket("U1", "S1", "A1");
        System.out.println(ticket);
    }
}
