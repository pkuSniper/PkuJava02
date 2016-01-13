package leetcode;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
public class Solution226 {
	
    public  TreeNode invertTree(TreeNode root) {
    	invertBST(root);
		return root;
    }
    public void invertBST(TreeNode root)
    {
    	if(root == null)
    		return ;
    	TreeNode t =root.left;
    	root.left = root.right;
    	root.right = t;
    	invertBST(root.left);
    	invertBST(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		Solution226 so = new Solution226();
		TreeNode resl = so.invertTree(root);
		System.out.print(resl.val +"-"+resl.left.val+"-"+resl.left.left.val);

	}

}
