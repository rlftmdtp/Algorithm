package baekjoon.gold2;

import java.io.*;
import java.util.*;


public class Baekjoon_11779 {
	public static int dist[];
	public static int before[];
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 초기화
		List<Node> graph[] = new ArrayList[n+1];
		dist = new int[n+1];
		before = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			String strSplit[] = br.readLine().split(" ");
			int start = Integer.parseInt(strSplit[0]);
			int end = Integer.parseInt(strSplit[1]);
			int w = Integer.parseInt(strSplit[2]);
			// 방향 그래프
			graph[start].add(new Node(end, w));
		}
		
		String strSplit[] = br.readLine().split(" ");
		int start = Integer.parseInt(strSplit[0]);
		int end = Integer.parseInt(strSplit[1]);
		
		dijkstra(start, graph);
		// 방문했던 도시 탐색
		Stack<Integer> st = traverse(end);
		
		System.out.println(dist[end]);
		System.out.println(st.size());
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
	
	public static Stack<Integer> traverse(int end) {
		Stack<Integer> st = new Stack<>();
		st.add(end);
		
		while(before[end] != 0) {
			st.add(before[end]);
			end = before[end];
		}
		
		return st;
	}
	
	public static void dijkstra(int start, List<Node> graph[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 아직 우선순위 큐에 남아있는 거리에 대해서 방문 중복체크
			if(dist[n.v] < n.w) continue;
			
			List<Node> list = graph[n.v];
			for(int i=0; i<list.size(); i++) {
				Node next_n = list.get(i);
				
				if(dist[next_n.v] > n.w + next_n.w) {
					dist[next_n.v] = n.w + next_n.w;
					before[next_n.v] = n.v;
					pq.add(new Node(next_n.v, n.w + next_n.w));
				}
			}
		}
	}

}
