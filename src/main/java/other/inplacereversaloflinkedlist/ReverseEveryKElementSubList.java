package other.inplacereversaloflinkedlist;

import other.ListNode;

/*Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.*/
//Time: O(n)
//Space: O(1)
public class ReverseEveryKElementSubList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 3, i;
        ListNode temp = head, start, prev = null, reversedLinkedList, newHead = null;
        while (temp != null) {
            start = temp;
            i = 0;
            while(temp != null && i < k) {
                temp = temp.next;
                i++;
            }
            reversedLinkedList = getReversedLinkedList(start, temp);
            if(newHead == null) {
                newHead = reversedLinkedList;
            } else {
                prev.next = reversedLinkedList;
            }
            prev = start;
        }

        ListNode it = newHead;
        while(it != null) {
            System.out.print(it.value + " ");
            it = it.next;
        }
    }

    private static ListNode getReversedLinkedList(ListNode head, ListNode stop) {
        ListNode temp = head, prev = stop, next;
        while (temp != stop) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
