package function;

import model.Order;
import model.RewardPoints;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Compose {
  public static void main(String[] args) {
    Order order = new Order(1);

    Function<Order, RewardPoints> totalBasedRewardPoints = Compose::calculateRewardPoints;
    UnaryOperator<RewardPoints> roundRewardPoints = Compose::roundRewardPoints;

    RewardPoints totalRewardPoints = roundRewardPoints.apply(totalBasedRewardPoints.apply(order));

    System.out.println(totalRewardPoints);
  }

  private static RewardPoints calculateRewardPoints(Order order) {
    return new RewardPoints(19);
  }

  private static RewardPoints roundRewardPoints(RewardPoints rewardPoints) {
    return new RewardPoints(rewardPoints.points()/10 * 10);
  }
}

