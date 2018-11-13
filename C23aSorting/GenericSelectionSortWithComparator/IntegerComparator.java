import java.util.Comparator;

public class IntegerComparator<T> implements Comparator<Object> {
  public int compare(Object lhs, Object rhs) {
    return Integer.compare((Integer)lhs, (Integer)rhs);
  }
}
