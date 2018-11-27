public class ComparableRectangle extends ComparableShape {
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
}
