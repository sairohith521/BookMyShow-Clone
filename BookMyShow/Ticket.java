package BookMyShow;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ticket {
    String movieName;
    int numberOfTickets;
    String date;
    int cost;
    ArrayList<Integer>list=new ArrayList<>();
    Ticket(String movieName, int numberOfTickets,int cost,ArrayList<Integer>list) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.date = LocalDate.now().toString();
        this.cost=cost;
        this.list=list;
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("tickets.txt", true);
            fw.write("Date: " + date + ", Movie: " + movieName + ", Tickets: " + numberOfTickets+", Total Cost: " + cost*numberOfTickets + "\n");
            fw.close();
            System.out.println();
            System.out.println(" Ticket saved successfully!");
            System.out.println();
            System.out.println("<-------Cost of the Ticket is "+cost*numberOfTickets+ ". ------------>");
        } catch (IOException e) {
            System.out.println(" Error saving ticket.");
        }
    }
}
