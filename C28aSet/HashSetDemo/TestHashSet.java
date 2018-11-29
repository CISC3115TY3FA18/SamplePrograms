/**
 * This example is from Chapter 21 in
 *   Liang Y Daniel, Introduction to Java Programming, 11st Edition
 */

import java.util.Set;
import java.util.HashSet;

public class TestHashSet {
  public static void main(String[] args) {
    // Create a hash set
    Set<String> set = new HashSet<String>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // Display the elements in the hash set
    for (String s: set) {
      System.out.print(s.toUpperCase() + " ");
    }

    // Process the elements using a forEach method
    System.out.println();
    set.forEach(new StringConsumer());
    System.out.println();
  }
}
