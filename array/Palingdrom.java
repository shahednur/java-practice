package array;

import java.util.Arrays;

public class Palingdrom {
    public static void main(String[] args) {
        int x = 022;
        // int[] digits = String.valueOf(x)
        // .chars()
        // .map(c -> c - '0')
        // .toArray();

        // if (digits.length > 2 && digits[0] == digits[2]) {
        // System.out.println("Yes");
        // } else {
        // System.out.println("No");
        // }

        // String s = String.valueOf(x);
        // int n = s.length();

        // for (int i = 0; x < n / 2; i++) {
        // if (s.charAt(i) != s.charAt(n - i - 1)) {
        // System.out.println("No");
        // }
        // }

        // System.out.println("Yes");

        String value = String.valueOf(x);
        StringBuilder sb = new StringBuilder(value);
        boolean result = sb.reverse().toString().equals(value);
        System.out.println("Result: " + result);

    }
}
