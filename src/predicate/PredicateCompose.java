package predicate;

import model.RewardPoints;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateCompose {
  public static void main(String[] args) {
    List<RewardPoints> list = Arrays.asList(
      new RewardPoints(10),
      new RewardPoints(20),
      new RewardPoints(45),
      new RewardPoints(90),
      new RewardPoints(100)
    );

    Predicate<RewardPoints> morethan40points = rp -> rp.points() > 40;
    Predicate<RewardPoints> lessthan100points = rp -> rp.points() < 100;

    List<RewardPoints> morethan40 = list.stream()
      .filter(morethan40points)
      .toList();
    System.out.println(morethan40);

    List<RewardPoints> lessthan100 = list.stream()
      .filter(lessthan100points)
      .toList();
    System.out.println(lessthan100);

    List<RewardPoints> more40less100 = list.stream()
      .filter(morethan40points.and(lessthan100points))
      .toList();
    System.out.println(more40less100);

    List<RewardPoints> more40less100b = list.stream()
      .filter(morethan40points)
      .filter(lessthan100points)
      .toList();
    System.out.println(more40less100b);

    List<RewardPoints> more10less80 = list.stream()
      .filter(rp -> rp.points() > 10 && rp.points() < 80)
      .toList();
    System.out.println(more10less80);

    List<RewardPoints> more10less45 = list.stream()
      .filter(rp -> rp.points() > 10)
      .filter(rp -> rp.points() < 45)
      .toList();
    System.out.println(more10less45);
  }
}
