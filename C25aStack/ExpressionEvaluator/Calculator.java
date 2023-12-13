public class Calculator {
  public static void main(String[] args) {
    InfixExpression expr = InfixExpression.parse("(1 + 2)*3");
    System.out.println(expr.toString());
  }
}
