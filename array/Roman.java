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

        String s = "LVIII";
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentVal = map.get(s.charAt(i));
            if (i + 1 < s.length()) {
                int nextVal = map.get(s.charAt(i + 1));
                // sum += (nextVal - currentVal);
                System.out.println("Yes: " + nextVal);
            } else {
                sum += currentVal;
            }

        }
        System.out.println("Output: " + sum);
    }
}
