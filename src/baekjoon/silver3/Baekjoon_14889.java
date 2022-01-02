package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_14889 {
	public static boolean visitied[];
	public static int MAP[][];
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		MAP = new int[N][N];
		visitied = new boolean[N];
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<strSplit.length; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// 나눌 수 있는 조합의 수
		int nums[] = new int[N];
		for(int i=0; i<nums.length; i++) {
			nums[i] = i+1;
		}
		combi(nums, N/2, 0);
		System.out.println(MIN);
	}
	
	public static void combi(int[] nums, int r, int depth) {
		if(r == 0) {
			// 조합
			List<Integer> team1 = new ArrayList<>();
			List<Integer> team2 = new ArrayList<>();
			for(int i=0; i<visitied.length; i++) {
				// System.out.println(i + "  " + visitied[i]);
				if(visitied[i] == true) team1.add(i);
				if(visitied[i] == false) team2.add(i);
			}
			
			// 구해진 팀으로 점수 구하기
			int team1_grade = calTeamGrade(team1);
			int team2_grade = calTeamGrade(team2);
			// System.out.println("팀 차이 " + Math.abs(team1_grade - team2_grade));
			MIN = Math.min(MIN, Math.abs(team1_grade - team2_grade));
		}else if(nums.length == depth) return;
		else {
			visitied[depth] = true;
			combi(nums, r-1, depth+1);
			
			visitied[depth] = false;
			combi(nums, r, depth+1);
		}
		
	}
	
	public static int calTeamGrade(List<Integer> team) {		
		int grade = 0;
		for(int i=0; i<team.size()-1; i++) {
			for(int j=i+1; j<team.size(); j++) {
				// System.out.println(team.get(i) + ", " + team.get(j));
				grade += MAP[team.get(j)][team.get(i)] + MAP[team.get(i)][team.get(j)];
			}
		}
		return grade;
	}

}
