package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class Baekjoon_2798 {
	
	public static int result = 0;
	public static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		M = Integer.parseInt(strSplit[1]);
		
		int nums[] = new int[N];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			nums[i] = Integer.parseInt(strSplit[i]);
		}
		
		combi(nums, 3, 0, 0);
		System.out.println(result);
	}
	
	public static void combi(int[] nums, int r, int depth, int sum) {
		if(r == 0) {
			// 최대값 구하기
			if(sum <= M) {
				result = Math.max(result, sum);
			}
		}else if(nums.length == depth) return;
		else {
			combi(nums, r-1, depth+1, sum+nums[depth]); // 선택
			combi(nums, r, depth+1, sum);
		}
	}
}
