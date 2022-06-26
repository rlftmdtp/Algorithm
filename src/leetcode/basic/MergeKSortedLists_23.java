package leetcode.basic;

import java.util.*;

public class MergeKSortedLists_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int i=0; i<lists.length; i++) {
    		ListNode listNode = lists[i];
    		
    		while(listNode.next != null) {
    			pq.add(listNode.val);
    			listNode = listNode.next;
    		}
    	}
    	
    	ListNode result = new ListNode();
    	while(!pq.isEmpty()) {
    		result.val = pq.poll();
    		result.next = new ListNode();
    		result = result.next;
    	}
    	
    	return result;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
