package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class NandM3_15651 {
	
	public static List<Integer> list = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		int nums[] = new int[N];
		for(int i=1; i<=N; i++) {
			nums[i-1] = i;
		}
		
		perm(nums, M);
		System.out.println(sb);
	}
	
	public static void perm(int[] nums, int r) {
		if(r == 0) {
			// Ãâ·Â
			for(int i=0; i<list.size(); i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}else {
			for(int i=0; i<nums.length; i++){
				list.add(nums[i]);
				perm(nums, r-1);
				
				list.remove(list.size()-1);
			}
		}
	}

}
