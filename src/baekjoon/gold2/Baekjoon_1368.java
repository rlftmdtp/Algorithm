package baekjoon.gold2;

import java.io.*;
import java.util.*;

public class Baekjoon_1368 {
	public static boolean visitied[];
	public static class Node implements Comparable<Node>{
		int n;
		int w;
		
		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
		
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Node> graph[] = new ArrayList[N+2];
		visitied = new boolean[N+2];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=1; i<=N; i++) {
			int w = Integer.parseInt(br.readLine());
			graph[i].add(new Node(N+1, w));
			graph[N+1].add(new Node(i, w));
		}
		
		for(int i=1; i<=N; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			for(int j=0; j<strSplit.length; j++) {
				int w = Integer.parseInt(strSplit[j]);
				// System.out.println("i번쨰에 " + i + " 물 넣기 " + w);
				if(w != 0) {
					graph[i].add(new Node(j+1,w));
					graph[j+1].add(new Node(i, w));
				}
			}
		}
		
		// 모든 논을 연결
		int result = prime(1, graph);
		System.out.println(result);
	}
	
	public static int prime(int start, List<Node> graph[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		int result = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// n-1만큼 돈다
			if(visitied[n.n] == true) continue;
			visitied[n.n] = true;
			result += n.w;
			
			List<Node> list = graph[n.n];
			for(int i=0; i<list.size(); i++) {
				Node next_n = list.get(i);
				if(visitied[next_n.n] == false) {
					pq.add(new Node(next_n.n, next_n.w));
				}
			}
		}
		
		return result;
	}

}
