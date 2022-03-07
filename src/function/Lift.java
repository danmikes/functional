package function;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;

public class Lift {
  public static <T,U> Function<Optional<T>, Optional<U>> lift(Function<T,U> f) {
    return optional -> optional.map(f);
  }

  public static <T,U> Function<T, Optional<U>> lift1(Function<T,U> f) {
    return val -> {
      try {
        return Optional.ofNullable(val).map(f);
      } catch (Exception e) {
        return Optional.empty();
      }
    };
  }

  public static void main(String[] args) {
    Function<Integer,Integer> doubler = x -> x * 2;

    Function<Optional<Integer>, Optional<Integer>> doublerOptional =
      lift(doubler);

    System.out.println(doublerOptional.apply(Optional.of(2)));
    System.out.println(doublerOptional.apply(Optional.empty()));

    Function<Integer, Optional<Integer>> doublerOriginal2 =
      lift1(doubler);

    System.out.println(doublerOriginal2.apply(2));
    System.out.println(doublerOriginal2.apply(null));
  }
}
