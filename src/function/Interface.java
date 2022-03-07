package function;

import java.util.function.Function;

public class Interface {
  public static void main(String[] args) {

    Alpha alpha = a -> b -> c -> a * b + c;
    Beta beta = alpha.apply(1L);
    Gamma gamma = beta.apply(2L);

    Long result0 = alpha.apply(1L).apply(2L).apply(5L);
    System.out.println("result0 = " + result0);

    Long result1 = gamma.apply(4L);
    System.out.println("result1 = " + result1);

    Long result2 = gamma.apply(3L);
    System.out.println("result2 = " + result2);
  }

  interface Alpha extends Function<Long, Beta> {}

  interface Beta extends Function<Long, Gamma> {}

  interface Gamma extends Function<Long,Long> {}
}
