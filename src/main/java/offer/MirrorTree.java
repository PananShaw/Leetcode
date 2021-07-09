package offer;

/**
 * @author shaw
 * @describe 剑指 Offer 27. 二叉树的镜像
 * @date 2021/07/09 14:28
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
