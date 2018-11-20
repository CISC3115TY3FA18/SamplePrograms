/*
 * This program is a sample program in Chapter 19 of
 * Liang Y Daniel, Introduction to Java Programming, 11st Edition
 * Minor revision applied.
 */
import java.util.ArrayList;
import java.util.List;

public class SuperWildCardDemo {
  public static void main(String[] args) {
    List<String> list1 = new ArrayList<String>();
    List<Object> list2 = new ArrayList<Object>();

    list2.add("Java");  // "Java" is a String, also an Object
    list2.add(2);       // 2 will be boxed as an Integer, also an Object
    list1.add("Sun");   // "Sum is a String"

    /**
     * move all elements from list1 to list2
     *
     * list1 is of List<String> list1, list2 is of List<Object>.
     *
     * The formal type T for parameters list1 and list2 in the move method below
    * will be replaced by concrete type String;
     *
     * and the format type ? super T  for parameter list2 in the move method
     * will be replaced by Object. Object is indeed a supertype of T.
     *
     * All is well.
     *
     */
    move(list1, list2);

    print(list2);
  }

  public static <T> void move(List<T> list1, List<? super T> list2) {
    while(!list1.isEmpty()) {
      list2.add(list1.remove(list1.size()-1));
    }
  }

  public static <T> void print(List<T> list) {
    for (T t: list) {
      System.out.println(t.toString());
    }
  }
}
