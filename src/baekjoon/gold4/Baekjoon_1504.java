package baekjoon.gold4;

import java.util.*;
import java.io.*;

public class Baekjoon_1504 {
	public static List<Node> graph[];
	private static final int INF = 200_000_000;
	public static class Node implements Comparable<Node>{
		int index;
		int w;
		
		public Node(int index, int w) {
			this.index = index;
			this.w = w;
		}
		
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int E = Integer.parseInt(strSplit[1]);
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			strSplit = br.readLine().split(" ");
			// 방향성 없는 그래프
			int v1 = Integer.parseInt(strSplit[0]);
			int v2 = Integer.parseInt(strSplit[1]);
			int w = Integer.parseInt(strSplit[2]);
			
			graph[v1].add(new Node(v2, w));
			graph[v2].add(new Node(v1, w));
		}
		
		strSplit = br.readLine().split(" ");
		int s1 = Integer.parseInt(strSplit[0]);
		int s2 = Integer.parseInt(strSplit[1]);
		
		// 1 -> s1 -> s2 -> N
		int result1 = bfs(1,s1);
		result1 += bfs(s1,s2);
		result1 += bfs(s2, N);
		
		// 1 -> s2 -> s1 -> N
		int result2 = bfs(1, s2);
		result2 += bfs(s2, s1);
		result2 += bfs(s1, N);
		
		result1 = Math.min(result1, result2);
		if(result1 >= INF) System.out.println(-1);
		else System.out.println(result1);
		
	}
	
	public static int bfs(int start, int find_node) {
		
		int distance[] = new int[graph.length];
		// boolean visitied[] = new boolean[graph.length];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			List<Node> list = graph[n.index];
			for(int i=0; i<list.size(); i++) {
				Node next_n = list.get(i);
					if(distance[n.index] + next_n.w < distance[next_n.index]) {
						distance[next_n.index] = distance[n.index] + next_n.w;
						pq.add(new Node(next_n.index, distance[next_n.index]));
					}
			}
		}
		
		// System.out.println(start + "  ->  " + find_node + " 의 값 " + distance[find_node]);
		return distance[find_node];
	}

}
