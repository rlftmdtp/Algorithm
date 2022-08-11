package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_15661 {
	public static boolean visitied[];
	public static int sta[][];
	public static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		4
//		0 1 2 3
//		4 0 5 6
//		7 1 0 2
//		3 4 5 0  최소 차이 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sta = new int[n][n];
		visitied = new boolean[n];
		
		for(int i=0; i<n; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			for(int j=0; j<strSplit.length; j++) {
				sta[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// 조합 구하기
		for(int i=1; i<=n; i++) {
			combi(i,0);
		}
		System.out.println(result);
	}
	
	public static void combi(int r, int depth) {
		if(r == 0) {
			// 팀 결정
			List<Integer> team1 = new ArrayList<>();
			List<Integer> team2 = new ArrayList<>();
			for(int i=0; i<visitied.length; i++) {
				if(visitied[i] == true) team1.add(i);
				else team2.add(i);
			}
			
			// 점수 계산
			int sum1 = calSta(team1);
			int sum2 = calSta(team2);
			// System.out.println("sum1 = " + sum1 + " sum2 = " + sum2);
			
			result = Math.min(Math.abs(sum1 - sum2), result);
			
			// 팀 확인
//			team1.forEach(i -> System.out.print(i + " "));
//			System.out.println();
//			team2.forEach(i -> System.out.print(i + " "));
//			System.out.println();
			
		}else if(depth == visitied.length) return;
		else {
			visitied[depth] = true;
			combi(r-1, depth+1);
			
			visitied[depth] = false;
			combi(r, depth+1);
		}
	}
	
	public static int calSta(List<Integer> team) {
		int sum = 0;
		for(int i=0; i<team.size()-1; i++) {
			for(int j=i+1; j<team.size(); j++) {
				sum += sta[team.get(i)][team.get(j)] + sta[team.get(j)][team.get(i)];
			}
		}
		
		return sum;
	}

}
