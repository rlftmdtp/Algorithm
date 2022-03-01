package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Baekjoon_1197 {
	public static int dist[];
	public static boolean visitied[];
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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int V = Integer.parseInt(strSplit[0]);
		int E = Integer.parseInt(strSplit[1]);
		
		List<Node> graph[] = new ArrayList[V+1];
		dist = new int[V+1];
		visitied = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			strSplit = br.readLine().split(" ");
			
			int u = Integer.parseInt(strSplit[0]);
			int v = Integer.parseInt(strSplit[1]);
			int w = Integer.parseInt(strSplit[2]);
			
			graph[u].add(new Node(v,w));
			graph[v].add(new Node(u,w));
		}
		
		int result = prime(1, graph);
		System.out.println(result);
	}

	private static int prime(int start, List<Node>[] graph) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		int result = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 노드의 개수만큼만 돈다
			if(visitied[n.v] == true) continue;
			visitied[n.v] = true;
			result += n.w;
			
			List<Node> list = graph[n.v];
			for(int i=0; i<list.size(); i++) {
				    Node next_n = list.get(i);
				
					if(visitied[next_n.v] == false) {
						// System.out.println("dist[n.v] + next_n.w " + (dist[n.v] + next_n.w));
						pq.add(new Node(next_n.v, next_n.w));
					}
				
			}
		}
		
		return result;
	}

}
