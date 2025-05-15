package algo;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {
    public List<List<Integer>> pathSum(TreeNodeAlg root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNodeAlg node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);
        remainingSum -= node.val;

        if (node.left == null && node.right == null && remainingSum == 0) {
            result.add(new ArrayList<>(currentPath));
        }

        dfs(node.left, remainingSum, currentPath, result);
        dfs(node.right, remainingSum, currentPath, result);

        currentPath.remove(currentPath.size() - 1); // Backtracking
    }
}
class TreeNodeAlg {
    int val;
    TreeNodeAlg left;
    TreeNodeAlg right;
    TreeNodeAlg() {}
    TreeNodeAlg(int val) { this.val = val; }
    TreeNodeAlg(int val, TreeNodeAlg left, TreeNodeAlg right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
