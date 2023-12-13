import java.util.Random;
import java.util.Arrays;

public class QuickSortClient {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: QuickSortClient <size of array to sort> <max number>");
      System.exit(1);
    }

    int size = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    int[] numbers = makeRandomArray(size, max);
    int[] numbersClone = Arrays.copyOf(numbers, numbers.length);
    // int[] numbers = {160, 218, 35, 222, 278};

    // printArray(numbers);

    // System.out.println("----------------------------------------------");

    long startTime = System.nanoTime();
    QuickSort.sort(numbers);
    long endTime   = System.nanoTime();
    System.out.println((double)(endTime - startTime)/1000000000.);

    startTime = System.nanoTime();
    BubbleSort.sort(numbersClone);
    endTime   = System.nanoTime();
    System.out.println((double)(endTime - startTime)/1000000000.);

    // printArray(numbers);
  }

  private static int[] makeRandomArray(int size, int max) {
    int[] numbers = new int[size];

    Random rng = new Random();

    for (int i=0; i<size; i++) {
      numbers[i] = rng.nextInt(max);
    }

    return numbers;
  }

  public static void printArray(int[] numbers) {
    for (int i=0; i<numbers.length; i++) {
      System.out.println("numbers[" + i + "] = " + numbers[i]);
    }
  }

}
