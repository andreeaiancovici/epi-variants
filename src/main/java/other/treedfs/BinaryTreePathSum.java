package other.treedfs;

import other.TreeNode;

/*Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf
such that the sum of all the node values of that path equals ‘S’.*/
public class BinaryTreePathSum {
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

        int s = 10;

        if (hasPathEqualToSum(tree, s)) {
            System.out.printf("Tree has path equal to %s.", s);
        } else {
            System.out.printf("Tree doesn't have path equal to %s.", s);
        }
    }

    private static boolean hasPathEqualToSum(TreeNode node, int s) {
        if (node == null) {
            return false;
        } else {
            s -= node.value;
            System.out.println(node.value);
            if (s == 0) {
                return true;
            } else {
                return hasPathEqualToSum(node.left, s) || hasPathEqualToSum(node.right, s);
            }
        }
    }
}
