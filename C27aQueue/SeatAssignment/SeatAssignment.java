import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class SeatAssignment {
  private static Random rng = new Random();
  private static int id = 0;

  public static void main(String[] args) {
    PriorityQueue<Passenger> queue = new PriorityQueue<Passenger>(new PassengerComparator());
    Plane plane = new Plane(100);
    passengerArrivals(queue, 5);
    passengerCheckIn(queue, plane);
    plane.printPassengerManifest();
  }

  private static void passengerArrivals(Queue<Passenger> queue, int maxPassengers) {
    for (int i=0; i<maxPassengers; i++) {
      Passenger p = makeRandomPassenger();
      queue.add(p);
    }
  }

  private static void passengerCheckIn(Queue<Passenger> queue, Plane plane) {
    while (!queue.isEmpty()) {
      Passenger passenger = queue.poll();
      int seatNo = plane.assignSeat(passenger);
      if (seatNo >=0 ) {
        System.out.println("Assigned passenger " + passenger.toString() + " at seat " + seatNo);
      } else {
        System.out.println("No more seats. Passenger " + passenger.toString() + " is on waiting list.");
      }
    }
  }

  private static Passenger makeRandomPassenger() {
    String[] names = {"John", "Tom", "Ben", "Arthur",
      "Emma", "Erica", "Sally", "Rose", "Uma", "Anthony", "Jerry", "Sasha", "Wendy"};
    int[] seatClasses = {1, 2};

    String name = names[rng.nextInt(names.length)];
    int seatClass = seatClasses[rng.nextInt(seatClasses.length)];
    id ++;
    return new Passenger(id, name, seatClass);
  }
}
