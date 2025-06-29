package stream;

import java.nio.file.*;
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
        IntStream rangeClosed = IntStream.rangeClosed(1, 10);

        // From Files
        // Stream<String> lines = Files.lines(Paths.get("file.txt"));

        // From Regex
        // Stream<String> words = Pattern.compile("\\s+").spliteAsStream("hello world
        // Java");

        System.out.println("result: " + range);
    }
}
