package function;

import model.TailCall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.TailCall.Suspend.done;
import static model.TailCall.Suspend.suspend;

public class RecurseList {
  public static void main(String[] args) {
    List<Integer> list0 = Arrays.asList(1,2,3,4);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    long top = System.nanoTime();
    long total = sum(list);
    long end = System.nanoTime();
    long time = end - top;
    System.out.println(total);

    long top2 = System.nanoTime();
    int total2 = sum1(list);
    long end2 = System.nanoTime();
    long time2 = end2 - top2;
    System.out.println(total2);

    long top3 = System.nanoTime();
    int total3 = sum1(list);
    long end3 = System.nanoTime();
    long time3 = end3 - top3;
    System.out.println(total3);

    System.out.println("time = " + time);
    System.out.println("time2 = " + time2);
    System.out.println("time3 = " + time3);
  }

  public static int sum(List<Integer> list) {
    return list.isEmpty()
      ? 0
      : head(list) + sum(tail(list));
  }

  public static int sum1(List<Integer> list) {
    return sumTail(list, 0);
  }

  public static int sum2(List<Integer> list) {
    return sumTail2(list, 0).eval();
  }

  private static int sumTail(List<Integer> list, int acc) {
    return list.isEmpty()
      ? acc
      : sumTail(tail(list), acc + head(list));
  }

  private static TailCall<Integer> sumTail2(List<Integer> list, int acc) {
    return list.isEmpty()
      ? done(acc)
      : suspend(() -> sumTail2(tail(list), acc + head(list)));
  }

  public static <T> T head(List<T> list) {
    return list.get(0);
  }

  public static <T> List<T> tail(List<T> list) {
    List<T> newList = new ArrayList<>(list);
    newList.remove(0);

    return newList;
  }
}
