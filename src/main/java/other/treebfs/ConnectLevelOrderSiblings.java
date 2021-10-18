package other.treebfs;

import other.ListNode;
import other.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConnectLevelOrderSiblings {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(3);
        TreeNode c4 = new TreeNode(4);
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(6);
        TreeNode c7 = new TreeNode(7);

        c2.left = c4;
        c2.right = c5;

        c3.left = c6;
        c3.right = c7;

        tree.left = c2;
        tree.right = c3;

        Deque<TreeNode> queue = new ArrayDeque<>();
        int levelCount = 1, count;
        TreeNode prev = null;

        queue.addLast(tree);

        while(!queue.isEmpty()) {
            count = 0;
            while(count < levelCount) {
                TreeNode node = queue.pollFirst();
                if(prev != null) {
                    prev.next = node;
                }
                if(node.left != null) {
                    queue.addLast(node.left);
                }
                if(node.right != null) {
                    queue.addLast(node.right);
                }
                prev = node;
                count++;
            }
            levelCount *= 2;
        }

        TreeNode it = tree;
        while(it != null) {
            System.out.print(it.value + " ");
            it = it.next;
        }
    }
}
