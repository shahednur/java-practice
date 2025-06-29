package stream;

import java.util.*;
import java.util.stream.Stream;

public class Lazy {
    public static void main(String[] args) {
        // filter() - Keep elements matching predicate
        List<String> list = Arrays.asList("a", "b", "c");
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = num.stream();
        Stream<String> stream2 = list.stream();
        stream1.filter(l -> l > 5);
        stream1.filter(Objects::nonNull);
        stream2.filter(String::isEmpty);

        // distinct() - Remove duplicate (uses equals())
        stream1.distinct();

        // limit() - Take first n elements
        stream1.limit(10);

        // skip() - Skip first n elements
        stream1.skip(5);

        // takeWhile() - Take elements while condition is thrue
        stream1.takeWhile(x -> x < 10);

        // dropWhile() - Drop elements while condition is true
        stream1.dropWhile(x -> x < 10);
    }
}
