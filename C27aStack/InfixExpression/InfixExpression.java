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
    for (String s: tokens) {
      System.out.println("Processing " + s);
      switch(s) {
        // dealing with oeprators
        case "+":
        case "-":
        case "*":
        case "/":
          processOperator(s, operatorStack, postfixList);
          break;
        // dealing with brackets
        case "(":
          operatorStack.push(s);
          break;
        case ")":
          processClosingBracket(operatorStack, postfixList);
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

  private void processOperator(String operator, Stack<String> operatorStack, List<String> postfixList) {
    if (operatorStack.isEmpty()) {
      operatorStack.push(operator);
    } else {
      processOperatorWithGreaterPrecedence(operator, operatorStack, postfixList);
      operatorStack.push(operator);
    }
  }

  private void processOperatorWithGreaterPrecedence(String operator, Stack<String> operatorStack, List<String> postfixList) {
    String top = operatorStack.peek();
    int topPrecedence = getPrecedence(top);
    int precedence = getPrecedence(operator);
    while (!operatorStack.isEmpty() && !top.equals("(") && precedence < topPrecedence) {
      operator = operatorStack.pop();
      postfixList.add(operator);
      if (!operatorStack.isEmpty()) {
        top = operatorStack.peek();
        topPrecedence = getPrecedence(top);
      }
    }
  }

  private void processClosingBracket(Stack<String> operatorStack, List<String> postfixList) {
    while (true) {
      if (operatorStack.isEmpty()) {
        throw new IllegalStateException("Operator Stack is empty");
      }
      String operator = operatorStack.pop();
      if (operator.equals("(")) {
        break;
      }
      postfixList.add(operator);
    }
  }

  private int getPrecedence(String operator) {
    int precedence = -1;
    switch(operator) {
      case "+":
      case "-":
        precedence = 1;
        break;
      case "*":
      case "/":
        precedence = 2;
        break;
      case ")":
        precedence = 999;
        break;
      case "(":
        precedence = -999;
        break;
      default:
        throw new IllegalArgumentException("Operator " + operator + " is not supported");
    }
    return precedence;
  }
}
