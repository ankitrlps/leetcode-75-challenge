import java.util.HashMap;
import java.util.Map;

class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        return dfs(root, targetSum, 0l, map);
    }

    int dfs(TreeNode root, int targetSum, long currentSum, Map<Long, Integer> map) {
        if (root == null)
            return 0;

        currentSum += root.val;

        int count = map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        count += dfs(root.left, targetSum, currentSum, map);
        count += dfs(root.right, targetSum, currentSum, map);

        map.put(currentSum, map.getOrDefault(currentSum, 0) - 1);

        return count;
    }

    public static void main(String[] args) {

    }
}