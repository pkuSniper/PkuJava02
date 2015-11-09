package xiefeng1;

 
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null){
    		return head;
    	}
    	ListNode tnode=head;
    	while(tnode.next!=null){
    		if(tnode.next.val==tnode.val){
            	tnode.next=tnode.next.next;
            }else{
            	tnode=tnode.next;
            }
    	}
    	return head;
    }
}
