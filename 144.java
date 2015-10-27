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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.empty())
        {
            if(root != null)
            {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }
}