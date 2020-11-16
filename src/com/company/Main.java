package com.company;
/**
 * See {@linktourl https://leetcode.com/problems/add-two-numbers/}
 * Current complexity: O(n)
 */
public class Main {
    public static void main(String[] args) {
        // write your code here
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println("end");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Assume that the 2 numbers do not contain any leading 0, except the number 0 itself.
        int sum = 0, i = 0, ans = 0;
        ListNode head = new ListNode();
        ListNode current = new ListNode();
        boolean end1 = false;
        boolean end2 = false;
        boolean carry = false;
        while (!end1 && !end2) {
            if (i == 0) {
                current = head;
            }
            sum = l1.val + l2.val;
            if (carry) {
                sum++;
            }
            if (sum / 10 > 0) {
                carry = true;
                sum %= 10;
            } else {
                carry = false;
            }
            current.val = sum;

            if (i == 0) {
                head.next = current;
            }
            //Sum two numbers
            //Carry if any
            if (l1.next == null) {
                end1 = true;
                current.next = null;
            } else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                end2 = true;
                current.next = null;
            } else {
                l2 = l2.next;
            }
            if (!end1 && !end2){
                current.next = new ListNode();
                current = current.next;
            }
            i++;
        }
        if (!end1 && end2) {
            while (l1.next != null) {
                current.val = l1.val;
                current.next = new ListNode();
                current = current.next;
                l1.next = l1;
            }
            current.val = l1.val;
        } else if (end1 && !end2) {
            while (l2.next != null) {
                current.val = l2.val;
                current.next = new ListNode();
                current = current.next;
                l2.next = l2;
            }
            current.val = l2.val;
        }
        current.next = null;
        return head;
    }
}