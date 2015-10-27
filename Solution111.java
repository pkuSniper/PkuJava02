package leetcode;

import java.util.*;

/*
 * 思路:用BFS搜索,当遇到第一个节点没有children则返回的长度是minDepth
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution111 {

	public int minDepth(TreeNode root) {        
    	if(root == null)
    		return 0;
    	int minDepth = 0;
    	TreeNode judge = new TreeNode(5);
    	List<TreeNode> queue = new ArrayList<TreeNode>();
    	List<TreeNode> queueTemp = new ArrayList<TreeNode>();
    	queue.add(root);
    	while(true)
    	{	
    		int count = 0;
    		while(true)
    		{
    			judge = queue.get(count);
    			queueTemp.add(judge);
    			count++;	
    			if(count == queue.size())
    				{
    					count = 0;
    					break;
    				}

    		}
    		minDepth++;
    		queue.clear();
    		int count2 = 0;
    		while(true)
    		{
    			judge = queueTemp.get(count2);
    			if(judge.left == null && judge.right == null)
				{
					return minDepth;
				}
        		if(judge.left != null)
            		queue.add(judge.left);
        		if(judge.right != null)
            		queue.add(judge.right);
        		count2++;
        		if(count2 == queueTemp.size())
        		{
        			count2 = 0;
        			break;
        		}
    		}
    		queueTemp.clear();
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		root.left = node1;
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
//		root.left.left.left.right = new TreeNode(5);
//		root.left.left.left.left = new TreeNode(6);

		Solution111 sol = new Solution111();
		int depth = sol.minDepth(root);
		System.out.println(depth);


		
	}

}

