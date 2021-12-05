package baekjoon.silver3;

import java.io.*;
import java.util.*;


public class NandM {
	public static boolean visitied[];
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String split[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		// 단순 수열 문제  3  1
		
		visitied = new boolean[N];
		int nums[] = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		perm(nums, M);
		
	}

	private static void perm(int nums[], int r) {
		// TODO Auto-generated method stub
		if(r == 0) {
			// 출력
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}else {
			for(int i=0; i<nums.length; i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					list.add(nums[i]);
					perm(nums, r-1);
					
					visitied[i] = false;
					list.remove(list.size()-1);
				}
			}
		}

	}

}
