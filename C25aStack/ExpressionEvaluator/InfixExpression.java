import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.Stack;

public class InfixExpression {
  private List<Token> tokenList;

  public InfixExpression(List<Token> tokenList) {
      this.tokenList = tokenList;
  }

  public double evaluate() {
    List<Token> postfixList = new LinkedList<Token>();

    Stack<Token> operatorStack = new Stack<Token>();

    for (Token t: tokenList) {
      if (t instanceof Operator) {
        postfixList.add(t);
      } else {
        Token top = operatorStack.peek();
        if (top instanceof Operator &&
          ((Operator)top).getPrecedence() > ((Operator)t).getPrecedence()) {
          top = operatorStack.pop();
          postfixList.add(top);
          operatorStack.push(t);
        }

      }
    }

    return 0.;
  }

  public String toString() {
    // in Java 8 or newer, we could simply write this using "stream", and "map & reduce".
    // return tokenList.stream().map(Token::toString).collect(Collectors.joining(" "));
    // but the following will just do the work,
    StringBuilder sb = new StringBuilder();
    for (Token t: tokenList) {
      sb.append(t).append(' ');
    }
    return sb.toString();
  }

  public static InfixExpression parse(String expression) {
    List<Token> tokenList = new LinkedList<Token>();

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<expression.length(); i++) {
      if (Operator.isValid(expression.charAt(i))) {
          String token = sb.toString().strip();
          if (!token.isBlank()) {
            tokenList.add(new Operand(token));
            sb.setLength(0);
          }
          tokenList.add(new Operand(sb.append(expression.charAt(i)).toString()));
          sb.setLength(0);
      } else if (Parenthesis.isValid(expression.charAt(i))) {
          String token = sb.toString().strip();
          if (!token.isBlank()) {
            tokenList.add(new Operand(token));
            sb.setLength(0);
          }
          tokenList.add(new Parenthesis(sb.append(expression.charAt(i)).toString()));
          sb.setLength(0);
      } else {
          sb.append(expression.charAt(i));
      }
    }
    String token = sb.toString().strip();
    if (!token.isBlank()) {
      tokenList.add(new Operand(token));
      sb.setLength(0);
    }
    return new InfixExpression(tokenList);
  }

  // /**
  //  * We could also use regular expression ...
  //  */
  // public static InfixExpression parse(String expression) {
  //   // define delimiter to split strings
  //   // delimiter 1. empty character before or after +
  //   final String plus = "(?<=\\+)|(?=\\+)";
  //   // delimiter 2. empty character before or after -
  //   final String minus = "(?<=-)|(?=-)";
  //   // delimiter 3. empty character before or after *
  //   final String multiplication = "(?<=\\*)|(?=\\*)";
  //   // delimiter 4. empty character before or after /
  //   final String division = "(?<=/)|(?=/)";
  //   // delimiter 5. empty character before or after (
  //   final String leftparen = "(?<=\\()|(?=\\()";
  //   // delimiter 6. empty character before or after )
  //   final String rightparen = "(?<=\\))|(?=\\))";
  //   // delimiters of the above
  //   final String delimiters = "(" + plus + ")|" +
  //                             "(" + minus + ")|"  +
  //                             "(" + multiplication + ")|" +
  //                             "(" + division + ")|" +
  //                             "(" + leftparen + ")|" +
  //                             "(" + rightparen + ")";
  //
  //   String[] tokens = expression.split(delimiters);
  //   List<String> tokenList = new LinkedList<String>();
  //   for (String t: tokens) {
  //     if (!t.isBlank()) {
  //       tokenList.add(t.strip());
  //     }
  //   }
  //   return new InfixExpression(tokenList);
  // }
}
