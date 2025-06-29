package stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

class Person {
    String name = "Shahed";
    int age = 32;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

public class Transformation {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        Person person = new Person();

        Stream<String> stream1 = list.stream();
        Stream<Integer> stream2 = number.stream();

        // map() - Transform each element
        stream1.map(String::toUpperCase);
        stream2.map(x -> x * 2);
        // stream1.map(person.name);

        // flatMap() - Transform and flatten
        // stream1.flatMap(Collection::stream);
        stream1.flatMap(s -> Arrays.stream(s.split("  ")));

        // mapToInt/Long/Double - Convert to primitive streams
        stream1.mapToInt(String::length);
        stream2.mapToDouble(Integer::doubleValue);

        // peek() - Perform action without changing elements (debugging)
        stream1.peek(System.out::println);
        // stream1.peek(x -> log.debug("Processing: {}", x));

        // sorted() - Natural ordering
        stream1.sorted();

        // sorted(Comparator) - Custom ordering
        stream1.sorted(Comparator.reverseOrder());
        // stream1.sorted(Comparator.comparing(Person::getAge));
        // stream1.sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
    }
}
