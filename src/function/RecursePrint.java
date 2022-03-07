package function;

public class RecursePrint {
  public static void main(String[] args) {
    printWithLoop(10);
    printRecursive(10);
  }

  public static void printWithLoop(int n) {
    for(int i = 1; i <= n; i++) {
      System.out.println(i);
    }
  }

  public static void printRecursive(int i) {
    if (i > 0) {
      printRecursive(i - 1);
      System.out.println(i);
    }
  }
}
