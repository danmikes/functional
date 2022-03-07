package predicate;

import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateComposeIdentity {
  private static <T> Predicate<T> andPredicates(Predicate<T>... predicates) {
    Predicate<T> p = x -> true;// Identity

    // imperative style
//    for (int i = 0; i < predicates.length; i++) {
//      p = p.and(predicates[i]);
//    }
//    return p;

    // declarative style
    return Arrays.stream(predicates).reduce(p, Predicate::and);
  }
}
