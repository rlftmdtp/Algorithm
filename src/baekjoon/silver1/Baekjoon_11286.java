package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Number> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pq.isEmpty()) sb.append(0 + "\n");
				else{
					// 절대값이 작은개 여러개일 경우 가장 작은 값 출력
					sb.append(pq.poll().n + "\n");
				}
			}else pq.add(new Number(n, Math.abs(n)));
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Number implements Comparable<Number>{
		int n;
		int absN;
		
		public Number(int n, int absN) {
			this.n = n;
			this.absN = absN;
		}

		@Override
		public int compareTo(Number o) {
			// TODO Auto-generated method stub
			if(this.absN == o.absN) {
				return this.n - o.n;
			}else return this.absN - o.absN;
		}
	}

}
