package leetcode.basic;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,7,11,15};
		twoSum(nums, 9);
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	int test = (Integer) null;
    	
    	Arrays.sort(nums);
    	// 오름차순 정렬
    	return binarySearch(nums, target);
    }
    
    public static int[] binarySearch(int[] nums, int target) {

    	int start = 0;
    	int end = nums.length-1;
    	
    	while(start < end) {
    		int mid = (start+end) / 2;
    		if(nums[start] + nums[end] == target) break;
    		else if(target < nums[start] + nums[end]) end = mid;
    		else start = mid;
    	}
    	
    	// System.out.println("start " + start + " end " + end);
    	int result[] = {start, end};
    	return result;
    }

}
