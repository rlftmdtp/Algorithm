package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_11724 {
	public static boolean[] visitied;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		// 그래프 생성
		List<Integer> graph[] = new ArrayList[N+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			
			int u = Integer.parseInt(strSplit[0]);
			int v = Integer.parseInt(strSplit[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		visitied = new boolean[N+1];
		// 연결 요소의 개수 연결된곳의 탐방이 끝나면 +1증가
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(visitied[i] == false) result += bfs(i, graph);
		}
		System.out.println(result);
	}
	
	public static int bfs(int start, List<Integer> graph[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			
			List<Integer> list = graph[u];
			for(int i=0; i<list.size(); i++) {
				int v = list.get(i);
				if(visitied[v] == false) {
					visitied[v] = true;
					q.add(v);
				}
			}
		}
		
		return 1;
	}

}
