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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root!=null || !stack.empty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right==null || root.right==pre)
            {
                list.add(root.val);
                pre = root;
                stack.pop();
                root = null;
            }
            else
                root = root.right;
        }
        return list;
    }
}