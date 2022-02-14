package baekjoon.gold2;

import java.util.*;
import java.io.*;

public class Baekjoon_1766 {
	public static int solved[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		solved = new int[N+1];
		// graph생성
		List<Integer> graph[] = new ArrayList[N+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			int u = Integer.parseInt(strSplit[0]);
			int v = Integer.parseInt(strSplit[1]);
			// 4 -> 2 단반향 (위상)
			
			graph[u].add(v);
			solved[v]++;
		}
		
		// 3. 쉬운 문제 푸터 풀기
//		for(int i=1; i<=N; i++) {
//			if(solved[i] >= 0) {
//				// 2. 먼저 풀 수 있는 문제 체크
//				solved[i]--;
//				levelCheck(i, graph);
//			}
//		}
		
		levelCheck(graph);
		System.out.println(sb.toString());
	}
	
	public static void levelCheck(List<Integer> graph[]) {
		// 쉬운 문제푸터 시작을 위해 pq 사용
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<solved.length; i++) {
			if(solved[i] == 0) pq.add(i); // indegree가 0일 경우 ( 들어오는 선이 0개 일 경우)
		}
		
		while(!pq.isEmpty()) {
			int node = pq.poll();
			sb.append(node + " ");
			
			List<Integer> list = graph[node];
			for(int i=0; i<list.size(); i++) {
				int next_node = list.get(i);
				solved[next_node]--; // 다음 간선이 있는 곳으로 방문
				if(solved[next_node] == 0) pq.add(next_node);
			}
		}
	}
	
	
//	public static void levelCheck(int level, List<Integer> graph[]) {
//		// System.out.println("level " + level);
//		List<Integer> list = graph[level];
//		// 먼저 풀어야 좋은 문제가 있을 경우
//		if(list.size() != 0) {
//			for(int i=0; i<list.size(); i++) {
//				int another_level = list.get(i);
//				if(solved[another_level] >= 0) {
//					solved[another_level]--;
//					levelCheck(another_level, graph);
//				}
//			}
//		}
//		
//		System.out.println(level + " 풀었다 ");
//		sb.append(level + " ");
//	}

}
