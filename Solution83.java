package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode cur = head;
    	Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
    	while(cur != null)
    	{
    		if(!map.containsKey(cur.val))
    		{
    			map.put(cur.val, 1);

    		}
    		cur = cur.next;
    		if(cur == null)
    			break;

    	}
    	
    	Iterator iter = map.entrySet().iterator();
    	ListNode newHead = new ListNode(2);
    	head = newHead;
    	while(iter.hasNext())
    	{
    		Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) iter.next();
    		newHead.val = entry.getKey();
    		if(iter.hasNext())
    		{
        		ListNode newNode = new ListNode(1);
        		newHead.next = newNode;
    		}
    		newHead = newHead.next;
    	} 
    	
		return head;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(4);
		
		Solution83 so = new Solution83();
		ListNode node1 = so.deleteDuplicates(head);
		while(node1!=null)
		{
			System.out.println(node1.val);
			node1 = node1.next;
		}

	}

}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
