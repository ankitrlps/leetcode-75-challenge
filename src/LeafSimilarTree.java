import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 */

public class LeafSimilarTree {
    public static void main(String[] args) {
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverseTree(root1, list1);
        traverseTree(root2, list2);
        return list1.equals(list2);
    }

    private void traverseTree(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            traverseTree(root.left, list);
        }
        if (root.right != null) {
            traverseTree(root.right, list);
        }
    }
}