import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Plane {
  private int seatCapacity;
  private List<Integer> availSeatNoList;

  // two parallel lists for seat assignment
  private List<Integer> occupiedSeatNoList;
  private List<Passenger> passengerList;

  private Random rng;

  public Plane(int numberOfSeats) {
    seatCapacity = numberOfSeats;
    availSeatNoList = new LinkedList<Integer>();
    for (int i=0; i<numberOfSeats; i++) {
      availSeatNoList.add(i);
    }
    occupiedSeatNoList = new LinkedList<Integer>();
    passengerList = new LinkedList<Passenger>();

    rng = new Random();
  }

  public int assignSeat(Passenger p) {
    if (availSeatNoList.isEmpty()) {
      return -1;
    }

    // simulate passenger selecting a seat
    int size = availSeatNoList.size();
    int seatIndex = rng.nextInt(size);
    Integer seatNo = availSeatNoList.get(seatIndex);

    // assign seat
    passengerList.add(p);
    occupiedSeatNoList.add(seatNo);
    availSeatNoList.remove(seatIndex);

    return seatNo;
  }

  public void printPassengerManifest() {
    Iterator<Passenger> passengerIter = passengerList.iterator();
    Iterator<Integer> seatIter = occupiedSeatNoList.iterator();

    while(passengerIter.hasNext() && seatIter.hasNext()) {
      Passenger passenger = passengerIter.next();
      Integer seat = seatIter.next();
      System.out.println(passenger.toString() + "@[SeatNo= " + seat + "]");
    }
  }

}
