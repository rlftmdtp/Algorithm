package baekjoon.silver2;

import java.util.*;
import java.io.*;


public class DfsBfs_1260 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String split[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int start = Integer.parseInt(split[2]);

		List<Integer> graph[] = new ArrayList[N+1];
		for(int i =0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			split = br.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			int V = Integer.parseInt(split[1]);
			graph[v].add(V);
			graph[V].add(v);
		}
		
		// dfs();
		bfs(graph, start);

	}

	private static void bfs(List<Integer>[] graph, int start) {
		// TODO Auto-generated method stub
		boolean visitied[] = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();
		visitied[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v + " ");
			List<Integer> list = graph[v];
			// 정점 번호가 작은 것 부터 방문
			Collections.sort(list);
			for(int i=0; i<list.size(); i++) {
				int near = list.get(i);
				if(visitied[near] == false) {
					visitied[near] = true;
					q.add(near);
				}
			}
		}
	}

}
