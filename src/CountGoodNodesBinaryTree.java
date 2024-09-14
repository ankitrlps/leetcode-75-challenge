public class CountGoodNodesBinaryTree {

    /**
     * https://leetcode.com/problems/count-good-nodes-in-binary-tree
     * @param root
     * @return
     */

    public int goodNodes(TreeNode root) {
        return find(root, root.val, 0);
    }

    private int find(TreeNode node, int maxVal, int goodNodes) {
            if (node.val >= maxVal) {
                maxVal = node.val;
                goodNodes++;
            }

            if (node.left != null) {
                goodNodes = find(node.left, maxVal, goodNodes);
            }
            
            if (node.right != null) {
                goodNodes = find(node.right, maxVal, goodNodes);
            }

        return goodNodes;
    }

    public static void main(String[] args) {
        
    }
}
