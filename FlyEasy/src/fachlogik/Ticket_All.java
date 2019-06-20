package fachlogik;

import java.util.ArrayList;
import java.util.List;

public class Ticket_All extends Ticket_General {

    private List<Ticket_General> tickets = new ArrayList<>();


    public String printInfo() {
        String toBeReturned = "";

        for (Ticket_General t : tickets) {
            toBeReturned.concat(t.printInfo() + "\n");
        }
        return toBeReturned;
    }

    public void add(Ticket_General ticket_general) {
        if (ticket_general.getFlug() == tickets.get(0).getFlug() || tickets.isEmpty()) {
            tickets.add(ticket_general);
        } else {
            System.out.println("Das Ticket gehört zu einem anderen Flug!");
        }
    }

    public void remove(Ticket_General ticket_general) {
        tickets.remove(ticket_general);
    }

}
