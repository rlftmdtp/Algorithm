package baekjoon.gold4;

import java.util.*;
import java.io.*;

public class Baekjoon_1967 {
	public static boolean visitied[];
	public static int MAX = 0;
	public static int INDEX = 0;
	
	static class Node{
		int index;
		int w;
		
		public Node(int index, int w) {
			this.index = index;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Node> graph[] = new ArrayList[N+1];
		visitied = new boolean[N+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			String strSplit[] = br.readLine().split(" ");
			int parent = Integer.parseInt(strSplit[0]);
			int child = Integer.parseInt(strSplit[1]);
			int weight = Integer.parseInt(strSplit[2]);
			
			graph[parent].add(new Node(child, weight));
			graph[child].add(new Node(parent, weight));
		}
		
		dfs(1, graph, 0); // 하나의 정점에서 가장 먼 정점을 찾는다
		MAX = 0;
		visitied = new boolean[N+1];
		dfs(INDEX, graph, 0); // 발견한 가장 먼 점에서 다른 가장 먼점을 찾으면 된다
		System.out.println(MAX);
	}
	
	public static void dfs(int parent, List<Node> graph[], int w) {
		visitied[parent] = true;
		
		List<Node> list = graph[parent];
		for(int i=0; i<list.size(); i++) {
			Node child = list.get(i);
			// System.out.println("방문 노드 " + child.index);
			if(visitied[child.index] == false) {
				// System.out.println("방문 노드 " + child.index);
				dfs(child.index, graph, w+child.w);
			}
		}
		
		if(w > MAX) {
			MAX = w;
			// System.out.println("MAX " + MAX);
			INDEX = parent;
		}
	}

}
