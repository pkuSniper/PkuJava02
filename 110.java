/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else if(depth(root.left)-depth(root.right)>1 || depth(root.right)-depth(root.left)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if(root == null)
            return 0;
        int depth1 = depth(root.left), depth2 = depth(root.right);
        return (depth1>depth2?depth1:depth2) + 1;
    }
}