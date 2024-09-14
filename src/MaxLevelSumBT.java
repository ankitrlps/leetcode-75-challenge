import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBT {

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 0;
        int minLevel = 1;
        while (que.size() > 0) {
            int size = que.size();
            int i = 1;
            int levelSum = 0;
            while (i <= size) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                levelSum += node.val;
                i++;
            }
            level++;
            if (levelSum > max) {
                max = levelSum;
                minLevel = level;
            }
        }
        return minLevel;
    }

    public static void main(String[] args) {
        
    }
}
