package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_15664 {
	public static HashSet<String> hs = new HashSet<>();
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int n = Integer.parseInt(strSplit[0]);
		int m = Integer.parseInt(strSplit[1]);
		
		int input[] = new int[n];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			input[i] = Integer.parseInt(strSplit[i]);
		}
		Arrays.sort(input);
		
		combi(input, m, 0);
	}
	
	public static void combi(int input[], int r, int depth) {
		if(r == 0) {
			StringBuilder sb = new StringBuilder();
			for(int i : list) {
				sb.append(i + " ");
			}
			
			if(!hs.contains(sb.toString())) {
				hs.add(sb.toString());
				System.out.println(sb.toString());
			}
		}else if(depth == input.length) return;
		else {
			list.add(input[depth]);
			combi(input, r-1, depth+1);
			
			list.remove(list.size()-1);
			combi(input, r, depth+1);
		}
	}
}
