package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_15663 {
	public static boolean visitied[];
	public static List<Integer> list = new ArrayList<>();
	public static HashSet<String> hs = new HashSet<>();
	public static StringBuilder sb = new StringBuilder();
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int n = Integer.parseInt(strSplit[0]);
		int m = Integer.parseInt(strSplit[1]);
		
		int input[] = new int[n];
		visitied = new boolean[n];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			input[i] = Integer.parseInt(strSplit[i]);
		}
		Arrays.sort(input);
		//  ¼ø¿­
		perm(input, m);
		System.out.println(sb.toString());
	}

	public static void perm(int input[], int r) {
		if(r == 0) {
			StringBuilder inner_sb = new StringBuilder();
			for(int i : list) {
				inner_sb.append(i + " ");
			}
			// System.out.println(sb.toString());
			
			if(!hs.contains(inner_sb.toString())) {
				hs.add(inner_sb.toString());
				sb.append(inner_sb.toString()).append("\n");
			}
		}else {
			for(int i=0; i<input.length; i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					list.add(input[i]);
					perm(input, r-1);
					visitied[i] = false;
					list.remove(list.size()-1);
				}
			}
		}
	}
}
