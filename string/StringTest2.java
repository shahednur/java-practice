package string;

public class StringTest2 {
    public static void main(String[] args) {
        String a = "Hellow";
        String b = "Hellow";
        String c = new String("Hellow");

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));
    }
}
