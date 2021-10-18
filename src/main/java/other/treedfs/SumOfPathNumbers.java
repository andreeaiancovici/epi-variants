package other.treedfs;

import other.TreeNode;

/*Given a binary tree where each node can only have a digit (0-9) value,
each root-to-leaf path will represent a number. Find the total sum of all
the numbers represented by all paths.*/
public class SumOfPathNumbers {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(7);
        TreeNode c3 = new TreeNode(9);
        TreeNode c6 = new TreeNode(2);
        TreeNode c7 = new TreeNode(9);

        c3.left = c6;
        c3.right = c7;

        tree.left = c2;
        tree.right = c3;

        System.out.printf("Total sum of path numbers is %d.", sumOfPathNumbers(tree, 0));
    }

    private static int sumOfPathNumbers(TreeNode node, int number) {
        if (node == null) {
            return 0;
        } else {
            number = 10 * number + node.value;
            if(node.left == null && node.right == null) {
                return number;
            }
            int leftSum = sumOfPathNumbers(node.left, number);
            int rightSum = sumOfPathNumbers(node.right, number);
            return leftSum + rightSum;
        }
    }
}
