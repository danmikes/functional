package model;

public record RewardPoints(Integer points) {
  public RewardPoints combine(RewardPoints rewardPoints) {
    return rewardPoints.combine(rewardPoints);
  }

  @Override
  public String toString() {
    return "RewardPoints{" +
      "points=" + points +
      '}';
  }
}
