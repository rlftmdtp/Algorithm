package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_1766 {
	public static boolean visitied[];
	public static Stack<Integer> st = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		List<Integer> graph[] = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 가능하면 쉬운문제 인 것 부터 따로 보관
		List<Integer> priorityList = new ArrayList<>();
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			graph[Integer.parseInt(strSplit[0])].add(Integer.parseInt(strSplit[1]));
			priorityList.add(Integer.parseInt(strSplit[0]));
		}
		
		visitied = new boolean[N+1];
		// 위상정렬 DFS 탐색
		// 쉬운 리스트 부터 먼저 푼 다음 다음에 푼다
		for(int i=0; i<priorityList.size(); i++) {
			int node = priorityList.get(i);
			if(visitied[node] == false) {
				dfs(node, graph);
			}
		}
			
		for(int i=1; i<=N; i++) {
			if(visitied[i] == false) {
				dfs(i, graph);
			}
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println();
	}
	private static void dfs(int node, List<Integer> graph[]) {
		// TODO Auto-generated method stub
		visitied[node] = true;
		List<Integer> list = graph[node];
		
		for(int i=0; i<list.size(); i++) {
			int next_node = list.get(i);
			if(visitied[next_node] == false) {
				dfs(next_node, graph);
			}
		}
		 
		// System.out.println("최종 확인 " + node);
		st.add(node);
	}

}
