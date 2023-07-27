package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 extends BuildTree{

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> temp= new ArrayList<>();
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        pathSumSolution(root, targetSum);
        return lists;
    }

    public void pathSumSolution(Node root, int targetSum) {
        if (root == null)
            return;

        temp.add(root.data);

        if (root.left == null && root.right == null && root.data == targetSum) {
            // Create new list of a copy of temp and store it into lists
            lists.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        pathSumSolution(root.left, targetSum-root.data);
        pathSumSolution(root.right, targetSum-root.data);
        temp.remove(temp.size()-1);
    }
}
