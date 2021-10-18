package other.treebfs;

import other.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*Find the minimum depth of a binary tree. The minimum depth is the
number of nodes along the shortest path from the root node to the nearest leaf node.*/
//Time: O(n)
//Space: O(n)
public class MinimumDepthOfABinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(3);
        TreeNode c4 = new TreeNode(4);
        TreeNode c5 = new TreeNode(5);

        c2.left = c4;
        c2.right = c5;

        tree.left = c2;
        tree.right = c3;

        int minDepth = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(tree);
        int levelCount = 1, level = 1;
        int count;
        boolean nodeFound = false;
        while(!queue.isEmpty()) {
            count = 0;
            while(count < levelCount) {
                TreeNode node = queue.pollFirst();
                if(node.left == null || node.right == null) {
                    minDepth = level;
                    nodeFound = true;
                    break;
                } else {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
                count++;
            }
            if(nodeFound) {
                break;
            }
            levelCount *= 2;
            level++;
        }

        System.out.printf("Min depth of tree is %d.", minDepth);
    }
}
