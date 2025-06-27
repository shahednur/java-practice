package array;

public class Palindrom {
    public static void main(String[] args) {
        String s = "xcbabczterws";
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);

                String reversed = new StringBuilder(sub).reverse().toString();
                if (sub.equals(reversed) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        System.out.println("Palindromic: " + longest);
    }
}
