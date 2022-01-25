package baekjoon.silver2;

import java.util.*;
import java.io.*;

public class Baekjoon_11725 {
	public static List<Integer> graph[];
	public static int result[];
	public static boolean visitied[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		result = new int[N+1];
		visitied = new boolean[N+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			String strSplit[] = br.readLine().split(" ");
			int node1 = Integer.parseInt(strSplit[0]);
			int node2 = Integer.parseInt(strSplit[1]);
			
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		
		dfs(1); // 루트노드1 번 시작
		for(int i=2; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void dfs(int parent) {
		visitied[parent] = true;
		
		List<Integer> list = graph[parent];
		for(int i=0; i<list.size(); i++) {
			int child = list.get(i);
			if(visitied[child] == false) {
				result[child] = parent;
				dfs(child);
			}
		}
	}

}
