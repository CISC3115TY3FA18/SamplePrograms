import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class InfixExpression {
  List<String> tokens;

  public InfixExpression(String[] tokens) {
    if (tokens == null) {
      throw new IllegalArgumentException("Tokens array is null");
    }
    this.tokens = new LinkedList<String>();
    for (String s: tokens) {
      this.tokens.add(s);
    }
  }

  public List<String> toPostfixList() {
    Stack<String> operatorStack = new Stack<String>();

    List<String> postfixList = new LinkedList<String>();
    String operator = null;
    String top = null;
    int topPrecedence;
    int precedence;
    for (String s: tokens) {
      System.out.println("Processing " + s);
      switch(s) {
        // dealing with oeprators
        case "+":
        case "-":
        case "*":
        case "/":
          if (operatorStack.isEmpty()) {
            operatorStack.push(s);
          } else {
            top = operatorStack.peek();
            if (!top.equals("(")) {
              topPrecedence = getPrecedence(top);
              precedence = getPrecedence(s);
              if (precedence <= topPrecedence) {
                operator = operatorStack.pop();
                postfixList.add(operator);
              }
            }
            operatorStack.push(s);
          }
          break;
        // dealing with brackets
        case "(":
          operatorStack.push(s);
          break;
        case ")":
          while (true) {
            if (operatorStack.isEmpty()) {
              throw new IllegalStateException("Operator Stack is empty");
            }
            operator = operatorStack.pop();
            if (operator.equals("(")) {
              break;
            }
            postfixList.add(operator);
          }
          break;
        // dealing with operants
        default:
            postfixList.add(s);
      }
    }

    while(!operatorStack.isEmpty()) {
      postfixList.add(operatorStack.pop());
    }

    return postfixList;
  }

  private int getPrecedence(String operator) {
    int precedence = 1;
    switch(operator) {
      case "+":
      case "-":
        break;

      case "*":
      case "/":
        precedence = 2;
        break;
      default:
        throw new IllegalArgumentException("Operator " + operator + " is not supported");
    }
    return precedence;
  }
}
