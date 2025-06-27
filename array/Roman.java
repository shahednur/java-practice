package array;

import java.util.*;

public class Roman {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String s = "XL";
        String sb = new StringBuilder(s).reverse().toString();
        int sum = 0;
        int prev = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int current = map.get(c);
            if (current < prev) {
                sum -= current;
            } else {
                sum += current;
            }

            prev = current;
        }
        System.out.println("Output: " + sum);
    }
}
