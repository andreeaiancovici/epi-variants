package other.treebfs;

import other.TreeNode;

import java.util.*;

/*Given a binary tree, populate an array to represent its level-by-level traversal in reverse order,
i.e., the lowest level comes first. You should populate the values of all nodes in each level from
left to right in separate sub-arrays.*/
//Time: O(n)
//Space: O(n)
public class ReverseLevelOrderTraversal {
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

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(tree);
        int level = 1, count, countPerLevel = 1;
        while (!queue.isEmpty()) {
            count = 0;
            while (count < countPerLevel) {
                TreeNode node = queue.pollFirst();
                stack.addFirst(node);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                count++;
            }
            countPerLevel *= 2;
            level++;
        }

        countPerLevel /= 2;
        while (!stack.isEmpty()) {
            System.out.println("Level " + level);
            count = 0;
            while (count < countPerLevel) {
                TreeNode node = stack.pollFirst();
                System.out.print(node.value);
                if (count < countPerLevel - 1) {
                    System.out.print(" ");
                } else System.out.print("\n");
                count++;
            }
            countPerLevel /= 2;
            level--;
        }
    }
}
