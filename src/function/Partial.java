package function;

import java.util.function.Function;

public class Partial {
  public static void main(String[] args) {
    Function<Double, Function<Double, Double>> calculateTax = rate -> amount -> amount * rate;

    Function<Double, Double> calculateNationalTax = calculateTax.apply(0.2);
    Function<Double, Double> calculateInternationalTax = calculateTax.apply(0.3);

    Double nationalTax = calculateNationalTax.apply(100.0);
    Double internationalTax = calculateInternationalTax.apply(100.0);

    System.out.println(nationalTax);
    System.out.println(internationalTax);

    Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;
    Function<Integer, Integer> addA = add.apply(3);
    Integer addB = addA.apply(6);
    System.out.println(addB);
  }
}
