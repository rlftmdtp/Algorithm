package baekjoon.gold4;

import java.util.*;
import java.io.*;

public class Baekjoon_1967 {
	public static boolean visitied[];
	
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
		for(int i=1; i<graph.length; i++) {
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
		
		dfs(1, graph, 0);
	}
	
	public static int dfs(int parent, List<Node> graph[], int w) {
		System.out.println(parent + " 방문처리 true");
		visitied[parent] = true;
		int result = 0;
		
		List<Node> list = graph[parent];
		for(int i=0; i<list.size(); i++) {
			Node child = list.get(i);
			// System.out.println("방문 노드 " + child.index);
			if(visitied[child.index] == false) {
				System.out.println("방문 노드 " + child.index);
				dfs(child.index, graph, w+child.w);
			}
		}
		System.out.println(parent + " 의 가중치 합  " + (result+w));
		return result + w;
	}

}
