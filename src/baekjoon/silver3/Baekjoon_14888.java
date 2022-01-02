package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_14888 {
	
	public static int nums[];
	public static boolean visitied[];
	public static int MIN = Integer.MAX_VALUE;
	public static int MAX = Integer.MIN_VALUE;
	public static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strSplit = br.readLine().split(" ");
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(strSplit[i]);
		}
		
		strSplit = br.readLine().split(" ");
		
		List<String> operators = new ArrayList<>();
		for(int i=0; i<4; i++) {
			int count = Integer.parseInt(strSplit[i]);
			for(int j=0; j<count; j++) {
				if(i == 0) operators.add("+");
				if(i == 1) operators.add("-");
				if(i == 2) operators.add("x");
				if(i == 3) operators.add("/");
			}
		}
		visitied = new boolean[operators.size()];
		// list로 순열 순서를 만든다
		// swap
		perm(operators, 0);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}

	private static void perm(List<String> operators, int depth) {
		// TODO Auto-generated method stub
		if(depth == operators.size()) {
			/*
			 * for(int i=0; i<list.size(); i++) { System.out.print(list.get(i) + " "); }
			 * System.out.println();
			 */
			int result = 0;
			result = calcu(nums[0], nums[1], list.get(0));
			for(int i=1; i<list.size(); i++) {
				result = calcu(result, nums[i+1], list.get(i));
			}
			
			MIN = Math.min(MIN, result);
			MAX = Math.max(MAX, result);
		}else {
			for(int i=0; i<operators.size(); i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					list.add(operators.get(i));
					perm(operators, depth+1);
					
					visitied[i] = false;
					list.remove(list.size()-1);
				}
			}
		}
	}

	private static int calcu(int x, int y, String string) {
		// TODO Auto-generated method stub
		if(string.equals("+")) {
			return x+y;
		}else if(string.equals("-")) {
			return x-y;
		}else if(string.equals("x")) {
			return x*y;
		}else {
			return x/y;
		}
	}


}
