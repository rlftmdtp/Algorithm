package CodeUp.backtracking;

import java.io.*;
import java.util.*;

public class CodeUp_3515 {
	public static int result = 0;
	public static int visitied[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int list[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				list[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// 완전탐색
		// 각 행과 열에 여러개의 사탕이 있는데, 각 행과 열이 겹치지 않게 사탕을 가져가라.
		visitied = new int[N]; // 행에 열이 들어가 있다
		Arrays.fill(visitied, -1);
		dfs(list, 0, 0);
		System.out.println(result);
	}
	
	public static void dfs(int list[][], int sum, int depth) {
		if(depth == list.length) {
			result = Math.max(result, sum);
		}else {
			// 해당 열의 하나를 선택
			for(int i=0; i<list.length; i++) {
				if(visitied[depth] == -1) {

					// 열 확인
					if(checkRow(i)) {
						// System.out.println("가능한 행 " + depth);
						// System.out.println("가능한 열" + i);
						visitied[depth] = i;
						dfs(list, sum + list[depth][i], depth+1);
						visitied[depth] = -1;
					}
				}
			}
			
		}
		
	}
	
	public static boolean checkRow(int index) {
		// 이미 선택한 행일 경우 불가
		for(int i=0; i<visitied.length; i++) {
			if(visitied[i] == index) return false;
		}
		return true;
	}

}
