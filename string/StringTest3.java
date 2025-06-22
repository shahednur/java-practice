package string;

public class StringTest3 {
    public static void main(String[] args) {
        String str = "   Java Master   ";

        System.out.println("Trim: " + str.trim());
        System.out.println("Upper: " + str.toUpperCase());
        System.out.println("Lower: " + str.toLowerCase());
        System.out.println("Length: " + str.length());
        System.out.println("CharAt(3): " + str.charAt(3));
        System.out.println("IndexOf(s): " + str.indexOf("s"));
        System.out.println("Replace: " + str.replace("v", "m"));
        System.out.println("StartsWith: " + str.trim().startsWith("Java"));
        System.out.println("EndsWith: " + str.trim().endsWith("Master"));
        System.out.println("IsEmpty: " + str.isEmpty());
    }
}
