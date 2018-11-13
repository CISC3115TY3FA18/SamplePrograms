import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
  public int compare(Integer lhs, Integer rhs) {
    return Integer.compare(lhs, rhs);
  }
}
