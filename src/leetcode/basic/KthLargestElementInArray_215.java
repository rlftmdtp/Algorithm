package leetcode.basic;

import java.util.*;

public class KthLargestElementInArray_215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums){
            if(pq.size() < k){
                pq.add(num);
            }else{
                if(pq.peek() < num){
                    pq.poll();
                    pq.add(num);   
                }
            }
        }
        
        return pq.poll();
    }

}
