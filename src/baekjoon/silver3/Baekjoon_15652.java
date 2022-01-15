package baekjoon.silver3;

import java.io.*;
import java.util.*;


public class Baekjoon_15652 {
	public static int array[];
	public static List<Integer> list = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		array = new int[N];
		for(int i=0; i<array.length; i++) {
			array[i] = i+1;
		}
		
		dfs(0,0,M);
	}
	
	public static void dfs(int start, int depth, int limit) {
		if(depth == limit) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
				sb.append(list.get(i) + " ");
			}
			System.out.println();
			sb.append("\n");
		}else {
			for(int i=start; i<array.length; i++) {
				list.add(array[i]);
				dfs(i, depth+1, limit);
				
				list.remove(list.size()-1);
			}
		}
	}

}
