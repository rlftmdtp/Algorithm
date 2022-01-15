package baekjoon.silver5;

import java.io.*;
import java.util.*;

public class Baekjoon_1427 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		while(N != 0) {
			// System.out.println("들어간 숫자 " + N%10);
			list.add(N%10);
			N = N/10;
		}
		
		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i : list) {
			sb.append(i);
		}
		System.out.println(sb);
	}

}
