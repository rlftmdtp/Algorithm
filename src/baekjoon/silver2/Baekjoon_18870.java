package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		int sort_list[] = list.clone();
		
		Arrays.sort(sort_list);
		HashMap<Integer, Integer> hm = new HashMap<>();
		// 중복을 없앤다 순서도 유지하기 위해서 HashMap
		int count = 0;
		for(int i=0; i<sort_list.length; i++) {
			if(!hm.containsKey(sort_list[i])) hm.put(sort_list[i], count++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.length; i++) {
			sb.append(hm.get(i) + " ");
		}
		
		System.out.println(sb.toString());
	}


}
