import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
  public int compare(Student lhs, Student rhs) {
    return lhs.getName().compareTo(rhs.getName());
  }
}
