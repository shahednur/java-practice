package stream;

import java.util.*;
import java.util.stream.*;

public class Collection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

        Stream<String> stream1 = list.stream();
        Stream<Integer> stream2 = num.stream();
        // collect() - Most flexible terminal operation
        List<String> list2 = stream1.collect(Collectors.toList());
        // Set<String> list3 = stream1.collect(Collectors.toMap(k, v));

        // Array()
        Object[] array1 = stream1.toArray();
        String[] array2 = stream1.toArray(String[]::new);

    }
}
