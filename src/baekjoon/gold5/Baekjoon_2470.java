package baekjoon.gold5;

import java.util.*;
import java.io.*;

public class Baekjoon_2470 {
	public static PriorityQueue<Solution> pq = new PriorityQueue<>();
	public static class Solution implements Comparable<Solution>{
		int start;
		int end;
		int gap;
		
		public Solution(int start, int end, int gap) {
			this.start = start;
			this.end = end;
			this.gap = gap;
		}
		
		public int compareTo(Solution s) {
			return this.gap - s.gap;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		Arrays.sort(list);
		binarySearch(list,0, list.length-1);
		System.out.println(pq.peek().start + " " + pq.peek().end);
	}
	
	public static void binarySearch(int[] list, int start, int end) {
		
		while(start < end) {
			// System.out.println("용액 합성 결과 " + (list[start] + list[end]));
			pq.add(new Solution(list[start], list[end], Math.abs(list[start] + list[end])));
			
			if(list[start] + list[end] >= 0) end--;
			else start++;
		}
	}

}
