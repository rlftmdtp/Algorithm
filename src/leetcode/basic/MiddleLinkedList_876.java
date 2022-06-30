package leetcode.basic;

import leetcode.basic.MergeKSortedLists_23.ListNode;

public class MiddleLinkedList_876 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode middleNode(ListNode head) {
        ListNode root = head;
        ListNode pointer = head;
        
        int len = 0;
        while(pointer != null){
            pointer = pointer.next;
            len++;
        }
        
        for(int i=0; i<len/2; i++){
            root = root.next;
        }
        
        return root;
    }

}
