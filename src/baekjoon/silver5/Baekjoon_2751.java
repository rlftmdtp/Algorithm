package baekjoon.silver5;

import java.io.*;
import java.util.*;

public class Baekjoon_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
		}
		
		// N개를 오름차순으로 정렬
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int n : list) {
			sb.append(n + "\n");
		}
		
		System.out.println(sb);
	}

}
