package other.fastslowpointers;

//Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
//Time: O(n)
//Space: O(1)
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null && second != null) {
            first = first.next;
            second = second.next;
            if(second != null) {
                second = second.next;
            }
            if(first == second) {
                return true;
            }
        }
        return false;
    }
}
