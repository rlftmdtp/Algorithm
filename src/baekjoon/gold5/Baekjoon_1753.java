package baekjoon.gold5;

import java.util.*;
import java.io.*;


public class Baekjoon_1753 {
	public static HashMap<Integer, List<Node>> graph = new HashMap<>();
	public static int distance[];
	static class Node implements Comparable<Node>{
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
		int V = Integer.parseInt(strSplit[0]);
		int E = Integer.parseInt(strSplit[1]);
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int start = Integer.parseInt(br.readLine());
		for(int i=1; i<=V; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			strSplit = br.readLine().split(" ");
			
			int u = Integer.parseInt(strSplit[0]);
			int v = Integer.parseInt(strSplit[1]);
			int w = Integer.parseInt(strSplit[2]);
			List<Node> list = graph.get(u);
			list.add(new Node(v, w));
			graph.put(u, list);
		}
		
		// 다익스트라
		bfs(start);
		for(int i=1; i<distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void bfs(int start) {
		distance[start] = 0;
		// visitied[]
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node u = pq.poll();
			List<Node> v = graph.get(u.index);
			for(int i=0; i<v.size(); i++) {
				Node next_n = v.get(i);
				if(u.w + next_n.w < distance[next_n.index]) {
					distance[next_n.index] = u.w + next_n.w;
					pq.add(new Node(next_n.index, distance[next_n.index]));
				}
			}
		}
	}

}
