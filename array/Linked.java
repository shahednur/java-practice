package array;

import java.util.*;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Linked {
    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1(2);
        l1.next = new ListNode1(4);
        l1.next.next = new ListNode1(3);

        ListNode1 prev = null;
        ListNode1 curr = l1;
        while (curr != null) {
            ListNode1 nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode1 node = prev;
        List<Integer> sum = new ArrayList<>();
        while (node != null) {
            sum.add(node.val);
            node = node.next;
        }
        for (int a1 : sum) {
            System.out.println("Result: " + a1);
        }
        // System.out.println("Result: " + sum);
        // ListNode2 l2 = new ListNode2(5);
        // l2.next = new ListNode2(6);
        // l2.next.next = new ListNode2(4);
    }
}
