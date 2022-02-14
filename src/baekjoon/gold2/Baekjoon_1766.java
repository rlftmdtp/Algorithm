package baekjoon.gold2;

import java.util.*;
import java.io.*;

public class Baekjoon_1766 {
	public static boolean solved[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		solved = new boolean[N+1];
		// graph����
		List<Integer> graph[] = new ArrayList[N+1];
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			int u = Integer.parseInt(strSplit[0]);
			int v = Integer.parseInt(strSplit[1]);
			// 4 -> 2 �ܹ��� (����)
			
			graph[v].add(u);
		}
		
		// 3. ���� ���� Ǫ�� Ǯ��
		for(int i=1; i<=N; i++) {
			if(solved[i] == false) {
				// 2. ���� Ǯ �� �ִ� ���� üũ
				levelCheck(i, graph);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void levelCheck(int level, List<Integer> graph[]) {
		// System.out.println("level " + level);
		List<Integer> list = graph[level];
		// ���� Ǯ��� ���� ������ ���� ���
		if(list.size() != 0) {
			for(int i=0; i<list.size(); i++) {
				int another_level = list.get(i);
				if(solved[another_level] == false) {
					levelCheck(another_level, graph);
				}
			}
		}
		
		// System.out.println(level + " Ǯ���� ");
		sb.append(level + " ");
		solved[level] = true;
	}

}
