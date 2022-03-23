package Programmers.level3;

import java.util.*;

public class Immigration {
	// https://intrepidgeeks.com/tutorial/coutlin-programmer-lv3-immigration-clearance
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int times[] = {7, 10};
		solution(n, times);
	}
	
    public static long solution(int n, int[] times) {
        long answer = 0;
        
        // 이분 탐색으로 최소시간을 찾는다 lowerBoundary
        return lowerBoundary(n, times);
    }
    
    public static long lowerBoundary(int n, int[] times) {
    	Arrays.sort(times);
    	long left = 1;
    	long right = (long)n * times[times.length-1];
    	while(left < right) {
    		long mid = (left+right)/2;
    		
    		// mid라는 시간동안 n명을 모두 다 처리할떄까지 얼마나 걸리는가?
    		long sum = 0;
    		for(int i=0; i<times.length; i++) {
    			sum += mid/times[i];
    		}
    		
    		if(n <= sum) right = mid;
    		else left = mid  + 1;	
    	}
    	System.out.println(left);
    	return left;
    }

}
