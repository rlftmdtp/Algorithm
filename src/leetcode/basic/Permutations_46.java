package leetcode.basic;

import java.util.*;

public class Permutations_46 {
	public static boolean visitied[];
	public static List<List<Integer>> result;
	public static List<Integer> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Input: nums = [1,2,3] Output:
		 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		 */
		
		int[] nums = {1,2,3};
		permute(nums);
	}
	
    public static List<List<Integer>> permute(int[] nums) {
    	visitied = new boolean[nums.length];
    	result = new ArrayList<>();
    	list = new ArrayList<>();
    	// ¼ø¿­
    	perm(nums, 0);
    	return result;
    }
    
    public static void perm(int nums[], int depth) {
    	if(depth == nums.length) {
    		result.add(new ArrayList<Integer>(list));
    	}else {
    		for(int i=0; i<nums.length; i++) {
    			if(visitied[i] == false) {
    				visitied[i] = true;
    				list.add(nums[i]);
    				perm(nums, depth+1);
    				
    				list.remove(list.size()-1);
    				visitied[i] = false;
    			}
    		}
    	}
    }

}
