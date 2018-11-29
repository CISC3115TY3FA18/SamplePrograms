public class ComparableCircle extends ComparableShape {
	private double radius;

	public ComparableCircle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
}
