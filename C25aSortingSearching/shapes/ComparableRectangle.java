public class ComparableRectangle extends Shape implements Comparable<ComparableRectangle> {
	private double width;
	private double length;

	public ComparableRectangle(String name, double width, double length) {
		super(name);
		this.width = width;
		this.length = length;
	}

	public double getArea() {
		return width * length;
	}

	public int compareTo(ComparableRectangle theOtherObject) {
    if (this.getArea() > theOtherObject.getArea()) {
      return 1;
    } else if (this.getArea() < theOtherObject.getArea()) {
      return -1;
    } else {
      return 0;
    }
  }

}
