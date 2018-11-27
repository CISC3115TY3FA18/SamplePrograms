public class Passenger {
  private int id;
  private String name;
  private int seatClass;

  public Passenger(int id, String name, int seatClass) {
    this.id = id;
    this.name = name;
    this.seatClass = seatClass;
  }

  public String toString() {
    return "Passenger[id=" + id + ",name=" + name + ",seatClass=" + seatClass + "]";
  }

  public int getSeatClass() {
    return this.seatClass;
  }
}
