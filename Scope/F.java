class F {
  private int i = 1;
  private int j = i+1;

  public void method() {
    static int k = 0;
  }

  public void printAll() {
    System.out.println("i = ", i);
    System.out.println("j = ", j);
    System.out.println("k = ", k);
  }

  public static void main(String[] args) {
    F f = new F();
    f.printAll();
  }
}
