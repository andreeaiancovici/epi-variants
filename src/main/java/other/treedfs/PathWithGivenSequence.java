package other.treedfs;

import other.TreeNode;

/*Given a binary tree and a number sequence, find if the sequence
is present as a root-to-leaf path in the given tree.*/
public class PathWithGivenSequence {
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

        int[] sequence = new int[]{1, 9, 9};
        if (isSequencePresent(tree, sequence, 0)) {
            System.out.println("Sequence is present");
        } else {
            System.out.println("Sequence is not present");
        }
    }

    private static boolean isSequencePresent(TreeNode node, int[] sequence, int index) {
        if (node == null) {
            return index == sequence.length;
        } else {
            if (index < sequence.length && node.value == sequence[index]) {
                return isSequencePresent(node.left, sequence, index + 1) || isSequencePresent(node.right, sequence, index + 1);
            } else {
                return false;
            }
        }
    }
}
