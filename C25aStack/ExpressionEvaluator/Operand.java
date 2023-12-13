public class Operand extends Token {
  public Operand(String operand) {
    super(operand);
  }

  public boolean isOperator() {
    return false;
  }
}
