package baekjoon.silver2;

import java.util.*;
import java.io.*;

public class Baekjoon_1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				if(pq.isEmpty()) sb.append("0 \n");
				else sb.append(pq.poll() + "\n");
			}else {
				pq.add(input);
			}
		}

		System.out.println(sb);
	}

}
