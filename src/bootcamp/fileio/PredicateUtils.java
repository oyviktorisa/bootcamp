package bootcamp.fileio;

import java.util.function.Predicate;

public class PredicateUtils
{
    @SafeVarargs
    public static <T> Predicate<T> combinedPredicate (Predicate<T>... tests) {
      Predicate<T> result = e -> true;
      for(Predicate<T> test: tests) {
        result = result.and(test);
      }
      return(result);
    }
}
