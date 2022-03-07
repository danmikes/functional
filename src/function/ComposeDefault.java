package function;

import model.Order;
import model.RewardPoints;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ComposeDefault {
  private static final int BASE = 19;//points
  private static final int BONUS = 50;//x/100
  private static final int ROUND = 5;//x%10

  public static void main(String[] args) {
    Order order = new Order(1);

    Function<Order, RewardPoints> totalRewardPoints = ComposeDefault::calculateRewardPoints;
    UnaryOperator<RewardPoints> addBonusPoints = ComposeDefault::addBonusPoints;
    UnaryOperator<RewardPoints> roundRewardPoints = ComposeDefault::roundRewardPoints;

    // round <- bonus <- total
    Function<Order, RewardPoints> f =
      roundRewardPoints
        .compose(addBonusPoints
          .compose(totalRewardPoints));

    // round <- total
    Function<Order, RewardPoints> f1 =
      roundRewardPoints
      .compose(totalRewardPoints);

    // total -> round
    Function<Order, RewardPoints> f2 =
      totalRewardPoints
      .andThen(roundRewardPoints);

    System.out.println(f.apply(order));
    System.out.println(f1.apply(order));
    System.out.println(f2.apply(order));
  }

  private static RewardPoints calculateRewardPoints(Order order) {
    return new RewardPoints(BASE);
  }

  private static RewardPoints addBonusPoints(RewardPoints rewardPoints) {
    return new RewardPoints((int) (rewardPoints.points() * (1 + BONUS/100F)));
  }

  private static RewardPoints roundRewardPoints(RewardPoints rewardPoints) {
    return new RewardPoints(rewardPoints.points() / ROUND * ROUND);
  }
}

