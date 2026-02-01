package LEETCODE;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ReorderList {

    public static ListNode inputList() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) return null;

        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int k = stack.size() / 2;
        curr = head;

        while (k-- > 0) {
            ListNode top = stack.pop();

            ListNode temp = curr.next;
            curr.next = top;
            top.next = temp;

            curr = temp;
        }

        curr.next = null;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ReorderList sol = new ReorderList();   // ✅ fixed

        ListNode head = inputList();
        sol.reorderList(head);                 // ✅ fixed
        printList(head);
    }
}
