package leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//因为是BST，所以可以根据BST的性质来做题。用递归。如果p、q分别在root两边则返回root。
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if((p.val <= root.val && q.val >= root.val ) || (p.val >= root.val && q.val <= root.val))
    		return root;
    	else if(p.val < root.val && q.val <root.val)
    		return lowestCommonAncestor(root.left, p, q);
    	else
    		return lowestCommonAncestor(root.right, p, q);
    	
    	
        
    }
	public static void main(String[] args) {
		Solution235 sol  = new Solution235();
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode (2);
		root.right = new TreeNode(10);
		TreeNode result = sol.lowestCommonAncestor(root, root.left, root.right);
		System.out.print(result.val);

	}

}
