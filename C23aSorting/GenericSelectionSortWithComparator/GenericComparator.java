import java.util.Comparator;
public class GenericComparator<T> implements Comparator<Integer> {
  public int compare(Integer lhs, Integer rhs) {
    if (lhs.intValue() < rhs.intValue()) return -1;
    else if (lhs.intValue() > rhs.intValue()) return 1;
    else return 0;
  }
}
