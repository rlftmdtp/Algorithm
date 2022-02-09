package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_12852 {
	public static int result = Integer.MAX_VALUE;
	public static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		dfs(x, 0, list);
		System.out.println(result);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int depth, List<Integer> list) {
		if(x == 1) {
			list.add(x);
			// 길이비교
			// System.out.println("depth " + depth);
			if(result > depth) {
				result = depth;
				sb = new StringBuilder();
				for(int i=0; i<list.size(); i++) {
					// System.out.print(list.get(i) + " ");
					sb.append(list.get(i) + " ");
				}
				sb.append("\n");
			}
			// System.out.println();
			list.remove(list.size()-1);
		}else {
			
			if(x%3 == 0) {
				list.add(x);
				dfs(x/3, depth+1, list);
				list.remove(list.size()-1);
			}
			
			if(x%2 == 0) {
				list.add(x);
				dfs(x/2, depth+1, list);
				list.remove(list.size()-1);
			}
			
			list.add(x);
			dfs(x-1, depth+1, list);
			list.remove(list.size()-1);
		}
	}

}
