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
		
		int n = Integer.parseInt(split[0]);
		int r = Integer.parseInt(split[1]);
		// 단순 수열 문제  3  1
		
		visitied = new boolean[n];
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = i+1;
		}
		
		perm(array, r);
		
	}

	private static void perm(int[] array, int r) {
		// TODO Auto-generated method stub
		if(r == 0) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}else {
			for(int i=0; i<array.length; i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					list.add(array[i]);
					perm(array, r-1);
					list.remove(list.size()-1);
					visitied[i] = false;
				}
			}
		}
	}

}
