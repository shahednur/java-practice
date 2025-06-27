package array;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Integer2Roman {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        List<String> names = Arrays.asList("Alice", "Bob", "Joe");
        names.sort((a, b) -> a.length() - b.length());

        // System.out.println(names);

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = num.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        // System.out.println(result);

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = words.stream()
                .filter(w -> w.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(filtered);

    }
}
