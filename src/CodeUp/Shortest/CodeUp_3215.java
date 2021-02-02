package CodeUp.Shortest;

import java.io.*;
import java.util.*;

public class CodeUp_3215 { // 최단 경로 1
	public static ArrayList<Node> graph[];
	public static int d[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split("\\s");
		
		int V = Integer.parseInt(strSplit[0]); // 정점개수
		int E = Integer.parseInt(strSplit[1]); // 에지개수
		
		d = new int[V+1]; // s에서 v까지의 최단거리 기록
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			strSplit = br.readLine().split("\\s");
			
			int u = strSplit[0].charAt(0) - 64;
			int v = strSplit[1].charAt(0) - 64;
			int distance = Integer.parseInt(strSplit[2]);
			
			graph[u].add(new Node(v, distance));
			graph[v].add(new Node(u, distance));
		}
		
		strSplit = br.readLine().split("\\s");
		int start = strSplit[0].charAt(0) - 64;
		int end = strSplit[1].charAt(0) - 64;
		
		dijkstra(start); // 출발점을 넘긴다
		System.out.println(d[end]);
	}
	
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		// 초기화
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		boolean visited[] = new boolean[graph.length];
		//
		
 		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, d[start]));
		
		int cnt = 0;
		while(!pq.isEmpty()){
			Node n = pq.poll();
			
			if(visited[n.v] == true) continue;
			
			visited[n.v] = true;
			cnt = cnt + 1;
			if(cnt == graph.length-1) break;
			
			ArrayList<Node> list = graph[n.v]; // v에 인접한 리스트 반환
			for(int i=0; i<list.size(); i++) {
				Node n2 = list.get(i);
				
				if(visited[n2.v] == false && d[n2.v] > d[n.v] + n2.distance) {
					d[n2.v] = d[n.v] + n2.distance;
					pq.add(new Node(n2.v, d[n2.v]));
				}
			}
		}
		// 경로가 없을 경우 처리
		for(int i=1; i<d.length; i++) {
			if(d[i] == Integer.MAX_VALUE)
				d[i] = -1;
		}
	}

	public static class Node implements Comparable<Node>{
		int v;
		int distance;
		
		public Node(int v, int distance) {
			this.v = v;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.distance, o.distance);
		}
	}

}
