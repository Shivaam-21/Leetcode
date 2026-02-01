package LEETCODE;

import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

class Swapnodesinpair {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;

        while (first != null && second != null) {
            ListNode third = second.next;

            second.next = first;
            first.next = third;

            if (prev != null) {
                prev.next = second;
            } else {
                head = second;
            }

            prev = first;
            first = third;

            if (third != null) {
                second = third.next;
            } else {
                second = null;
            }
        }

        return head;
    }

    // ✅ MAIN METHOD (INPUT + OUTPUT)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        // Input linked list values
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        ListNode head = dummy.next;

        // Call solution
        Swapnodesinpair sol = new Swapnodesinpair();
        ListNode result = sol.swapPairs(head);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
