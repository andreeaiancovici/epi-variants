package other.treedfs;

import other.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree and a number ‘S’, find all paths in the tree such that
the sum of all the node values of each path equals ‘S’. Please note that the
paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).*/
public class CountPathsForASum {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(7);
        TreeNode c3 = new TreeNode(9);
        TreeNode c4 = new TreeNode(6);
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(2);
        TreeNode c7 = new TreeNode(3);

        c2.left = c4;
        c2.right = c5;

        c3.left = c6;
        c3.right = c7;

        tree.left = c2;
        tree.right = c3;

        int s = 12;

        List<List<Integer>> results = new ArrayList<>();

        countPathsForASum(tree, s, results, new ArrayList<>());
        System.out.println("Done");
    }

    private static void countPathsForASum(TreeNode node, int s, List<List<Integer>> results, ArrayList<Integer> nodes) {
        if(node != null) {
            nodes.add(node.value);
            int pathSum = 0;
            for(int i = nodes.size() - 1; i >= 0; i--) {
                pathSum += nodes.get(i);
                if(pathSum == s) {
                    results.add(new ArrayList<>(nodes.subList(i, nodes.size())));
                }
            }
            countPathsForASum(node.left, s, results, nodes);
            countPathsForASum(node.right, s, results, nodes);
            nodes.remove(nodes.size() - 1);
        }
    }
}
