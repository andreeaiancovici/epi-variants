package other.treedfs;

import other.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*Given a binary tree and a number ‘S’, find all paths from root-to-leaf
such that the sum of all the node values of each path equals ‘S’.*/
public class AllPathsForASum {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(7);
        TreeNode c3 = new TreeNode(9);
        TreeNode c4 = new TreeNode(4);
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(2);
        TreeNode c7 = new TreeNode(7);

        c2.left = c4;
        c2.right = c5;

        c3.left = c6;
        c3.right = c7;

        tree.left = c2;
        tree.right = c3;

        int s = 12;

        List<List<Integer>> results = new ArrayList<>();

        allPathsForASum(tree, s, results, new ArrayList<>());

        System.out.printf("Paths that equal sum %d are:\n", s);
        results.forEach(System.out::println);
    }

    private static void allPathsForASum(TreeNode node, int s, List<List<Integer>> results, List<Integer> path) {
        if (node != null) {
            s -= node.value;
            path.add(node.value);
            if (s == 0) {
                results.add(new ArrayList<>(path));
            } else {
                allPathsForASum(node.left, s, results, path);
                allPathsForASum(node.right, s, results, path);
            }
            path.remove(path.size() - 1);
        }
    }
}
