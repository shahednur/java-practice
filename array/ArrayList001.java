package array;

import java.util.*;

public class ArrayList001 {
    public static void main(String[] args) {
        // Test random access speed
        List<Integer> result = new ArrayList<>();
        // List<Integer> linkedList = new LinkedList<>();
        // Set<String> uniqueNames = new HashSet<>();
        // Set<String> uniqueName = new LinkedHashSet<>();
        // Set<String> treeName = new TreeSet<>();
        // Map<String, String> orders = new HashMap<>();
        // Map<String, Integer> order = new LinkedHashMap<>();
        // Map<String, String> treeOrder = new TreeMap<>();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(new int[] { i, j });
                }
            }
        }

    }
}
