public class ComparableCircle extends Shape implements Comparable<ComparableCircle> {
	private double radius;

	public ComparableCircle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public int compareTo(ComparableCircle theOtherObject) {
    if (this.getArea() > theOtherObject.getArea()) {
      return 1;
    } else if (this.getArea() < theOtherObject.getArea()) {
      return -1;
    } else {
      return 0;
    }
  }

}
