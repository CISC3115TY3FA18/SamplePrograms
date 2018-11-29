/**
 * This example is from Chapter 21 in
 *   Liang Y Daniel, Introduction to Java Programming, 11st Edition
 */

import java.util.Set;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
  public static void main(String[] args) {
    // Create a hash set
    Set<String> set = new LinkedHashSet<>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // Display the elements in the hash set
    for (String element: set) {
      System.out.print(element + " ");
    }

    System.out.println();
    set.forEach(new StringConsumer());
    System.out.println();
  }
}
