public class DeleteNodeInBST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                root.val = curr.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);
        deleteNode(root, 3);
    }
}
