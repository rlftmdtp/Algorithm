package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_5557 {
	public static int result;
	public static List<Integer> check = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		combi(list, 0, 0);
		System.out.println(result);
	}
	
	public static void combi(int[] list, int depth, int sum) {
		if(depth == list.length-1) {
			if(sum == list[list.length-1]) {
				result++;
				
				for(int i : check) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}else if(sum < 0 || sum > 20) return;
		else {
			check.add(+list[depth]);
			combi(list, depth+1, sum + list[depth]);
			check.remove(check.size()-1);
			
			check.add(-list[depth]);
			combi(list, depth+1, sum - list[depth]);
			check.remove(check.size()-1);
		}
	}

}
