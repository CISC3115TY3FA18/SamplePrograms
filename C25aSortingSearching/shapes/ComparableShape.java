public abstract class ComparableShape implements Comparable<ComparableShape> {
  private String name;

  public ComparableShape(String name) {
    this.name = name;
  }

  public abstract double getArea();

  public String getName() {
    return name;
  }

  public int compareTo(ComparableShape theOtherObject) {
    if (this.getArea() > theOtherObject.getArea()) {
      return 1;
    } else if (this.getArea() < theOtherObject.getArea()) {
      return -1;
    } else {
      return 0;
    }
  }
}
