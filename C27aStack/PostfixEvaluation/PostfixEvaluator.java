import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class PostfixEvaluator {
  private List<String> tokens;

  public PostfixEvaluator(List<String> tokens) {
    this.tokens = tokens;
  }

  public PostfixEvaluator(String[] tokens) {
    if (tokens == null) {
      throw new IllegalArgumentException("Tokens array is null");
    }
    this.tokens = new LinkedList<String>();
    for (String s: tokens) {
      this.tokens.add(s);
    }
  }

  public double evaluate() {
    Stack<String> stack = new Stack<String>();

    double r = Double.NaN;
    String s1;
    String s2;
    Iterator<String> iter = tokens.iterator();
    while (iter.hasNext()) {
      String s = iter.next();
      switch(s) {
        case "+":
          s1 = stack.pop();
          s2 = stack.pop();
          r = Double.parseDouble(s1) + Double.parseDouble(s2);
          stack.push(Double.toString(r));
          break;
        case "-":
          s1 = stack.pop();
          s2 = stack.pop();
          r = Double.parseDouble(s2) - Double.parseDouble(s1);
          stack.push(Double.toString(r));
          break;
        case "*":
          s1 = stack.pop();
          s2 = stack.pop();
          r = Double.parseDouble(s1) * Double.parseDouble(s2);
          stack.push(Double.toString(r));
          break;
        case "/":
          s1 = stack.pop();
          s2 = stack.pop();
          r = Double.parseDouble(s2) / Double.parseDouble(s1);
          stack.push(Double.toString(r));
          break;
        default:
          stack.push(s);
      }
    }
    r = Double.parseDouble(stack.pop());
    if (!stack.isEmpty()) {
      throw new IllegalStateException("The posfix expression is in error");
    }
    return r;
  }

  public String getExpression() {
    return tokens.stream().collect(Collectors.joining(" "));
  }
}
