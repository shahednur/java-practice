package array;

import java.util.*;

public class ShoppingCartApp {
    public static void main(String[] args) {
        ArrayList<String> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---🛒 Shopping cart Menu ---");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View cart");
            System.out.println("4. Check if item exists");
            System.out.println("5. Total items");
            System.out.println("6. Clear cart");
            System.out.println("7. Exit");
            System.out.println("Enter choice");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter item to add: ");
                    String item = scanner.nextLine();
                    cart.add(item);
                    System.out.println(item + " add to cart.");
                }
                case 2 -> {
                    System.out.print("Enter item to remove: ");
                    String item = scanner.nextLine();
                    if (cart.remove(item)) {
                        System.out.println(item + " removed from cart.");
                    } else {
                        System.out.println(item + " not found in cart.");
                    }
                }
                case 3 -> {
                    System.out.println("\nYour Cart:");
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println((i + 1) + " . " + cart.get(i));
                    }
                }
                case 4 -> {
                    System.out.print("Enter item to check: ");
                    String item = scanner.nextLine();
                    if (cart.contains(item)) {
                        System.out.println(item + " is the cart.");
                    } else {
                        System.out.println(item + " is not in the cart. ");
                    }
                }
                case 5 -> {
                    System.out.println("Total items in cart: " + cart.size());
                }
                case 6 -> {
                    cart.clear();
                    System.out.println("Cart has been cleared.");
                }
                case 7 -> {
                    System.out.println("Thanks for shopping!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
