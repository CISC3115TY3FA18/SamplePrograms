public abstract class Triangle extends Shape {
	public Triangle(String name) {
		super(name);
	}
	public int getNumberOfSides() {
		return 3;
	}
	public abstract boolean isEquilateral();
}
