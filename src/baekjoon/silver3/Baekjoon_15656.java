package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_15656 {
	public static List<Integer> list = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
	
		int input[] = new int[N];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			input[i] = Integer.parseInt(strSplit[i]);
		}
		Arrays.sort(input);
		
		// ¼ø¿­
		perm(input, M);
		System.out.println(sb.toString());
	}
	
	public static void perm(int input[], int r) {
		if(r == 0) {
			for(int i : list) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}else {
			for(int i=0; i<input.length; i++) {
				list.add(input[i]);
				perm(input, r-1);
				list.remove(list.size()-1);
			}
		}
	}
}
