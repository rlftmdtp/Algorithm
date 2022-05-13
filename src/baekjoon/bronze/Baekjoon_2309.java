package baekjoon.bronze;

import java.io.*;
import java.util.*;


public class Baekjoon_2309 {
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int list[] = new int[9];
		for(int i=0; i<9; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		combi(list, 0, 7);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void combi(int[] list, int depth, int r) {
		if(r == 0) {
			
			// 합이 100 인지 확인
			int sum = 0;
			PriorityQueue<Integer> temp = new PriorityQueue<>();
			for(int i=0; i<result.size(); i++) {
				sum += result.get(i);
				temp.add(result.get(i));
			}
			
			if(sum == 100) {
				pq = temp;
			}
		}else if(depth == list.length) return; 
		else {
			result.add(list[depth]);
			combi(list, depth+1, r-1);
			
			result.remove(result.size()-1);
			combi(list, depth+1, r);
		}
	}

}
