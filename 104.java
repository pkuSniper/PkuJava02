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
    public int maxDepth(TreeNode root) {
        int depth=dfs(root, 1);
        return depth;
    }
    public int dfs(TreeNode root, int count)
    {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return count;
        else if(root.left==null)
            return dfs(root.right, count+1);
        else if(root.right==null)
            return dfs(root.left, count+1);
        else
            return max(dfs(root.left, count+1), dfs(root.right, count+1));
    }
    public int max(int a, int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
}