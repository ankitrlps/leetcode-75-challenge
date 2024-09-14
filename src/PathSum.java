public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, 0);
    }

    boolean dfs(TreeNode root, int targetSum, int sum) {
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (dfs(root.left, targetSum, sum)) return true;
        }
        if (root.right != null) {
            if (dfs(root.right, targetSum, sum)) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
    }
}
