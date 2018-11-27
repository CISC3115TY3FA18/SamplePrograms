import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class PostfixEvaluatorClient {
  public static void main(String[] args) {
    List<String> list = new LinkedList<String>();
    try (Scanner sc = new Scanner(System.in)) {
      while (true) {
        String line = sc.nextLine();
        if (line.isEmpty() || line.isBlank()) {
          continue;
        }
        if (line.equalsIgnoreCase("Bye")) {
          break;
        }
        // String[] tokens = line.split("\\s+");
        String[] tokens = line.split(" ");
        PostfixEvaluator evaluator = new PostfixEvaluator(tokens);
        double r = evaluator.evaluate();
        System.out.println(evaluator.getExpression() + " = " + r);
      }
    }
  }
}
