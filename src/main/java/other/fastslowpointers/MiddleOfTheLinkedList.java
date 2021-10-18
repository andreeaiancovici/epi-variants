package other.fastslowpointers;

import other.ListNode;

/*Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.*/
//Time: O(n)
//Space: O(1)
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        System.out.printf("The middle node of the LinkedList is %d.", first.value);
    }
}