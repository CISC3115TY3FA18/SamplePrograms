/**
 * Remark:
 * This design has some undesired property, for instance, when does a runtime error may
 * occur, and when? Is it possible to rewrite it using the java.util.Comparable interface
 * instead of the java.util.Comparator interface?
 *
 * We shall take a look at this progrma agian when we discuss "generics".
 */

import java.util.Random;

public class SelectionSortClient {
  public static void main(String[] args) {
    Integer[] numbers = makeRandomIntegerArray(10);

    System.out.println("Input Integer Array: ");
    printArray(numbers);

    SelectionSort<Integer> intSorter = new SelectionSort<Integer>();
    intSorter.sort(numbers, new IntegerComparator());

    System.out.println("Sorted Integer Array with Value as Key: ");
    printArray(numbers);


    System.out.println("--------------------------------");
    Shape[] shapes = makeRandomShapeArray(10);

    System.out.println("Input Shape Array: ");
    printArray(shapes);

    SelectionSort<Shape> shapeSorter = new SelectionSort<Shape>();
    shapeSorter.sort(shapes, new ShapeComparator());

    System.out.println("Sorted Shape Array with Area as Key: ");
    printArray(shapes);

    Student[] studentArray = {new Student("John"), new Student("Jane")};
    SelectionSort<Student> studentSorter = new SelectionSort<Student>();
    studentSorter.sort(studentArray, new StudentComparator());
  }


  private static Integer[] makeRandomIntegerArray(int size) {
    Random rng = new Random();
    Integer[] numbers = new Integer[size];
    for (int i=0; i<numbers.length; i++) {
      numbers[i] = rng.nextInt(100);
    }
    return numbers;
  }

  private static void printArray(Object[] objects) {
    for(Object o: objects) {
      System.out.println(o.toString());
    }
  }

  private static Shape[] makeRandomShapeArray(int size) {
    Random rng = new Random();
    Shape[] shapeArray = new Shape[size];

    final int numOfShapeTypes = 3;
    final double maxShapeSize = 10.;
    Shape s = null;

    for (int i=0; i<size; i++) {
      int type = rng.nextInt(numOfShapeTypes);
      switch(type) {
        case 0:
          double radius = rng.nextDouble()*maxShapeSize;
          s = new Circle("Circle_" + i, radius);
          break;
        case 1:
          double width = rng.nextDouble()*maxShapeSize;
          double length = rng.nextDouble()*maxShapeSize;
          s = new Rectangle("Rectangle_" + i, width, length);
          break;
        case 2:
        default:
          double base = rng.nextDouble()*maxShapeSize;
          double height = rng.nextDouble()*maxShapeSize;
          s = new RightTriangle("RightTriangle_" + i, base, height);
      }
      shapeArray[i] = s;
    }

    return shapeArray;
  }
}
