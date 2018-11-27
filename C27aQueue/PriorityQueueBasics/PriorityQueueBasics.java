import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class PriorityQueueBasics {
  private static Random rng = new Random();
  private static int id = 0;

  public static void main(String[] args) {
    PriorityQueue<Passenger> queue = new PriorityQueue<Passenger>(new PassengerComparator());
    enqueue(queue, 5);
    dequeue(queue);
  }

  private static void enqueue(Queue<Passenger> queue, int maxPassengers) {
    for (int i=0; i<maxPassengers; i++) {
      Passenger p = makeRandomPassenger();
      queue.add(p);
    }
  }

  private static void dequeue(Queue<Passenger> queue) {
    while (!queue.isEmpty()) {
      System.out.println("----------------");
      System.out.println("Peek at the queue of size " + queue.size());
      Passenger p = queue.peek();
      System.out.println("On the head of the queue is " + p.toString());
      System.out.println("Peeked at the queue of size " + queue.size());
      System.out.println("Poll at the queue of size " + queue.size());
      p = queue.poll();
      System.out.println("On the head of the queue is " + p.toString());
      System.out.println("Polled at the queue of size " + queue.size());
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
