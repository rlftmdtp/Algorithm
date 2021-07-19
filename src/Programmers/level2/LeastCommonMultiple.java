package Programmers.level2;

import java.util.*;

public class LeastCommonMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,6,8,14};
		System.out.println(solution(arr));
	}

    public static int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        int maxN = arr[arr.length-1];
        int count = 1;

        boolean go = true;
        while(go) {
        	answer = maxN * count;
        	for(int i=0; i<arr.length-1; i++) { // 자기자신 제외
        		if(answer % arr[i] != 0) break;
        		if(i == arr.length-2) go = false;
        	}
        	count++;
        }
        
        return answer;
    }
}
