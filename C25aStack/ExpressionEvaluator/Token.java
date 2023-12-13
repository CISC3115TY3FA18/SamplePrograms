public abstract class Token {
  private String value;

  public String toString() {
    return value;
  }

  public Token(String value) {
    this.value = value;
  }

  public String getToken() {
    return value;
  }
}
