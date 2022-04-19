package CodeUp.backtracking;

import java.io.*;
import java.util.*;

public class CodeUp_3520 {
	public static int[] MAP;
	public static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		MAP = new int[N+1];
		dfs(1);
		System.out.println(count);	
	}
	
	public static void dfs(int row) {
		if(row == MAP.length) {
			// 끝에 도달
			if(count < 3) {
				StringBuilder sb = new StringBuilder();
				for(int i=1; i<MAP.length; i++) {
					sb.append(MAP[i] + " ");
				}
				System.out.println(sb.toString());
			}
			
			count++;
		}else {
			// 백트래킹?
			// 열 선택
			for(int i=1; i<MAP.length; i++) {
				if(possible(row, i)) {
					MAP[row] = i;
					dfs(row+1);
				}
			}
		}
	}
	
	public static boolean possible(int row, int col) {
		// 1. 가로검사(할 필요가 없음)
		// 2. 세로검사
		for(int i=1; i<row; i++) {
			if(MAP[i] == col) return false;
			// 대각선 검사
			else if(row-i == Math.abs(col-MAP[i])) {
				return false;
			}
		}
		return true;
	}

}
