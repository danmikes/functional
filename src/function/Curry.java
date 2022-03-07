package function;

import java.util.function.Function;

public class Curry {
  public static void main(String[] args) {
    Apply reward = point -> ratio -> total -> total - (point * ratio);

    Function<Double, Function<Double, Double>> points = reward.apply(1.0);
    Function<Double, Double> ratio = points.apply(5.0);
    Double total = ratio.apply(10.0);
    System.out.println(total);
  }

  interface Apply extends
    Function<Double, Function<Double, Function<Double, Double>>> {}
}
