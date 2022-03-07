package model;

public class Tuple<T,U> {
  public final T x;
  public final T y;
  public final U z;

  public Tuple(T x, T y, U z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public String toString() {
    return "Tuple{" +
      "x=" + x +
      ", y=" + y +
      ", z=" + z +
      '}';
  }
}
