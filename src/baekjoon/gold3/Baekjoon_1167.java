package baekjoon.gold3;

import java.util.*;
import java.io.*;

public class Baekjoon_1167 {
	public static boolean visitied[];
	public static int distance[];
	
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Node n) {
			return n.distance - this.distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Node> graph[] = new ArrayList[N+1];
		visitied = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, 0);
		for(int i=1; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			// 3 1 2 4 3 -1
			for(int j=1; j<strSplit.length-1; j=j+2) {
				int start = Integer.parseInt(strSplit[0]);
				int n = Integer.parseInt(strSplit[j]);
				int distance = Integer.parseInt(strSplit[j+1]);
				// System.out.println(Integer.parseInt(strSplit[0]) + " 에서 " + n + " 까지의 거리 " + distance);
				graph[start].add(new Node(n, distance));
				// graph[n].add(new Node(start, distance));
			}
		}
		
		System.out.println(bfs(1,graph));
	}
	
	public static int bfs(int start , List<Node>[] graph) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		visitied[start] = true;
		distance[start] = 0;
		int result = Integer.MIN_VALUE;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			List<Node> list = graph[n.index];
			for(int i=0; i<list.size(); i++) {
				Node next_n = list.get(i);
				
				if(visitied[next_n.index] == false) {
					if(n.distance + next_n.distance > distance[next_n.index]) {
						visitied[next_n.index] = true;
						distance[next_n.index] = n.distance + next_n.distance;
						// System.out.println(n.index + " 와 " + next_n.index + " 의 거리 " + distance[next_n.index]);
						pq.add(new Node(next_n.index, distance[next_n.index]));
						result = Math.max(result,  distance[next_n.index]);
					}
				}
			}
		}
		
		// System.out.println("정답 " + result);
		return result;
	}

}
