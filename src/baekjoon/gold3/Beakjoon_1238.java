package baekjoon.gold3;

import java.io.*;
import java.util.*;

public class Beakjoon_1238 {
	public static int dis[];

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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		int X = Integer.parseInt(strSplit[2]);
		
		List<Node> graph[] = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			
			int start = Integer.parseInt(strSplit[0]);
			int end = Integer.parseInt(strSplit[1]);
			int w = Integer.parseInt(strSplit[2]);
			
			graph[start].add(new Node(end,w));
		}
		
		// X에서 집으로 돌아갈 때
		int dis_X[] = dijkstra(X, graph);
		// 각 지점에서의 거리구하기
		int MAX = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			int solo_dis[]= dijkstra(i, graph);
			
			// X까지 가는거리 + X에서 집으로 돌아오는 거리
			int distance = solo_dis[X] + dis_X[i];
			if(MAX < distance) MAX = distance;
		}
		System.out.println(MAX);
	}
	
	public static int[] dijkstra(int start, List<Node> graph[]) {
		// 하나의 지점에서 모든 최단 거리를 구한다
		dis = new int[graph.length];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node u = pq.poll();
			
			if(dis[u.n] < u.w) continue;
			
			List<Node> list = graph[u.n];
			for(int i=0; i<list.size(); i++) {
				Node v = list.get(i);
				
				if(dis[v.n] > v.w + u.w) {
					dis[v.n] = v.w + u.w;
					pq.add(new Node(v.n, dis[v.n]));
				}
			}
		}
		return dis.clone();
	}

}
