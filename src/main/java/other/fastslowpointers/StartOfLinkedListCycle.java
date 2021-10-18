package other.fastslowpointers;

import other.ListNode;

//Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
//Time: O(n)
//Space: O(1)
public class StartOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        int cycleLength = findLengthOfCycle(head);
        ListNode second = head;
        while(cycleLength > 0) {
            second = second.next;
            cycleLength--;
        }
        ListNode first = head;
        while(first != second) {
            first = first.next;
            second = second.next;
        }
        System.out.printf("Starting point of cycle is %d.", first.value);
    }

    private static int findLengthOfCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second) {
                break;
            }
        }
        ListNode tempFirst = head;
        int cycleLength = 0;
        while(tempFirst != first) {
            tempFirst = tempFirst.next;
            cycleLength++;
        }
        return cycleLength;
    }
}
