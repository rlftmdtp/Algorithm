package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Baekjoon_1987 {
	public static int MAP[][];
	// public static HashSet<String> hs = new HashSet<>(); -> 이걸로 풀면 시간초과뜸...
	public static boolean visitied[] = new boolean[26];
	public static int directX[] = {0,1,0,-1};
	public static int directY[] = {1,0,-1,0};
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int R = Integer.parseInt(strSplit[0]);
		int C = Integer.parseInt(strSplit[1]);
		MAP = new int[R][C];
		
		for(int i=0; i<R; i++) {
			strSplit = br.readLine().split("");
			for(int j=0; j<C; j++) {
				MAP[i][j] = strSplit[j].charAt(0) - 'A';		
			}
		}

		visitied[MAP[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int count) {
		if(answer < count) answer = count;
		
		for(int i=0; i<4; i++) {
			int new_x = x + directX[i];
			int new_y = y + directY[i];
			
			// 맵 범위
			if(new_x >=0 && new_x <MAP.length && new_y >=0 && new_y < MAP[0].length) {
				// 알파벳 중복 여부
				if(!visitied[MAP[new_x][new_y]]) {
					visitied[MAP[new_x][new_y]] = true;
					dfs(new_x, new_y, count+1);
					visitied[MAP[new_x][new_y]] = false;
				}
			}
		}
	}

}
