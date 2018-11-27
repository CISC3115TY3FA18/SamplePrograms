import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InfixExpressionClient {
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
        InfixExpression infixExpression = new InfixExpression(tokens);
        List<String> postfixList = infixExpression.toPostfixList();
        System.out.println("Posfix expression: " + postfixList.stream().collect(Collectors.joining(" ")));
      }
    }
  }
}
