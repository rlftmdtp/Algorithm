package leetcode.basic;

import java.util.*;

public class MajorityElement_169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int majorityElement(int[] nums) {
        
    	Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	for(int num : nums) {
    		hm.put(num, hm.getOrDefault(num, 0)+1);
    	}
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    	for(Integer key : hm.keySet()) {
    		
    		if(hm.get(key) > nums.length/2) pq.add(key);
    	}
    	
    	System.out.println(pq.peek());
    	return pq.poll();
    }

}
