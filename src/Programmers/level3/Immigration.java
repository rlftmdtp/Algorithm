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
        
        // �̺� Ž������ �ּҽð��� ã�´� lowerBoundary
        return lowerBoundary(n, times);
    }
    
    public static long lowerBoundary(int n, int[] times) {
    	Arrays.sort(times);
    	long left = 1;
    	long right = (long)n * times[times.length-1];
    	while(left < right) {
    		long mid = (left+right)/2;
    		
    		// mid��� �ð����� n���� ��� �� ó���ҋ����� �󸶳� �ɸ��°�?
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
