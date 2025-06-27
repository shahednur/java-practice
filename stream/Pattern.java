package stream;

import java.util.*;
import java.util.stream.*;

public class Pattern {
    public static void main(String[] args) {
        // From Collections
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = list.stream();
        Stream<String> parallelSteam = list.parallelStream();

        // From Arrays
        String[] array = { "X", "Y", "Z" };
        Stream<String> stream2 = Arrays.stream(array);
        Stream<String> stream3 = Stream.of("X", "Y", "Z");

        // Empty Stream
        Stream<String> empty = Stream.empty();

        // Infitie Streams
        Stream<Integer> infinite = Stream.iterate(0, n -> n + 2);
        Stream<Double> random = Stream.generate(Math::random);

        // Range Streams
        IntStream range = IntStream.range(1, 10);
        System.out.println("result: " + range);
    }
}
