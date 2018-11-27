import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<String>();
    enqueue(queue, args);
    dequeue(queue);
  }

  private static void enqueue(Queue<String> queue, String[] strings) {
    for (String s: strings) {
      queue.add(s);
    }
  }

  private static void dequeue(Queue<String> queue) {
    while (!queue.isEmpty()) {
      System.out.println("----------------");
      System.out.println("Peek at the queue of size " + queue.size());
      String s = queue.peek();
      System.out.println("On the head of the queue is " + s);
      System.out.println("Peeked at the queue of size " + queue.size());
      System.out.println("Poll at the queue of size " + queue.size());
      s = queue.poll();
      System.out.println("On the head of the queue is " + s);
      System.out.println("Polled at the queue of size " + queue.size());
    }
  }
}
