# Cinema Ticket Booking Facade in Java

I made this project for Assignment 4 to show how the Facade pattern works. My example is buying a cinema ticket. The project has four subsystem classes, one facade class, and two client examples. It uses Java 17 and does not need any extra libraries.

## How my program works

A customer chooses a show and a seat. The facade checks the show, reserves the seat, charges the customer, and creates a ticket. The client only needs one method call:

```java
CinemaTicketFacade cinema = new CinemaTicketFacade();
String ticket = cinema.buyTicket("U1", "S1", "A1");
```

I used two shows (`S1` and `S2`), two seats per show (`A1` and `A2`), and two customers (`U1` and `U2`). The data stays in memory. The payment and ticket are simulated; no real money is charged and nothing is printed on paper.

## Classes

| Class | What it does |
| --- | --- |
| `ShowtimeCatalog` | Checks the show and gives its movie title and price. |
| `SeatManager` | Reserves a seat or makes it free again. |
| `PaymentService` | Checks the balance, charges the customer, or refunds a charge. |
| `TicketPrinter` | Makes a numbered text ticket. |
| `CinemaTicketFacade` | Calls the four subsystems in the correct order. |
| `Client` | Buys a ticket through the facade. |
| `AdvancedClient` | Uses the subsystem classes directly, without the facade. |

I kept the subsystem classes public. They do not refer to `CinemaTicketFacade`, so an advanced client can still use them on its own. The regular `Client` uses only the facade.

## Clean Code choices

1. I used names such as `buyTicket`, `reserve`, and `charge` so the methods are easy to understand.
2. Each subsystem has one main job. The facade coordinates them instead of doing their work.
3. The regular client has a small API: it only calls `buyTicket`.
4. Unknown shows, occupied seats, and failed payments produce errors.
5. If a payment fails after a seat is reserved, the facade makes the seat free again. It also refunds a charge if a later step fails.

My [UML diagram and code explanation](EXPLANATION.md) show how the classes are connected. I also wrote a [short study guide](LEARNING_GUIDE.md) to help me prepare for the defense.
