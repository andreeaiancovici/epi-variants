package other.inplacereversaloflinkedlist;

import other.ListNode;

//Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
//Time: O(n)
//Space: O(1)
public class ReverseASubList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int p = 2, q = 4;

        ListNode temp = head, prev = null, next;
        int i = 1;
        while (i < p) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        while (i < q) {
            temp = temp.next;
            i++;
        }
        next = temp.next;

        prev.next = getReversedLinkedList(prev.next, next);

        ListNode it = head;
        while(it != null) {
            System.out.print(it.value + " ");
            it = it.next;
        }
    }

    private static ListNode getReversedLinkedList(ListNode head, ListNode stop) {
        ListNode temp = head, prev = stop, next;
        while(temp != stop) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
