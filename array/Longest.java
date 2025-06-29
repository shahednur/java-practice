package array;

public class Longest {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String maxLength = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                if (sub.length() > maxLength.length() && s.charAt(i) == s.charAt(j)) {
                    maxLength = sub;
                }
            }
        }
        System.out.println("String: " + maxLength.length());
    }
}
