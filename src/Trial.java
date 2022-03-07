import model.Order;

import java.util.Optional;

public class Trial {

  public static void main(String[] args) {
//    Order order;
//    Optional<Order> nullOrder = Optional.of(order);
//    System.out.println("nullOrder = " + nullOrder);

    Order order1 = new Order(1);
    Optional<Order> emptyOrder = Optional.ofNullable(order1);
    System.out.println("emptyOrder = " + emptyOrder);

    Optional<Order> emptyOptional = Optional.empty();
    System.out.println("emptyOptional = " + emptyOptional);

    Order order2 = emptyOrder.orElse(new Order(2));

    Order order3 = emptyOrder.orElseGet( () -> new Order(2) );

    emptyOptional.ifPresentOrElse(
      System.out::println,
      () -> System.out.println("empty")
    );
  }
}

