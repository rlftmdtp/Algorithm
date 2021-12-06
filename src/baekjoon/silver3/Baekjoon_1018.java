package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_1018 {
	public static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		String MAP[] = new String[N];
		for(int i=0; i<N; i++) {
			MAP[i] = br.readLine();
		}
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				dfs(MAP, "W", 0, i, j); // W로 시작
				dfs(MAP, "B", 0, i, j); // W로 시작
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(String[] MAP, String start_color, int sum, int x, int y) {
			
			for(int i=x; i<x+8; i++) {
				String temp_color = start_color;
				for(int j=y; j<y+8; j++) {
					System.out.println("i " + i + " j " + j);
					String map_color = MAP[i].charAt(j) + "";
					if(!temp_color.equals(map_color)) sum++;
					temp_color = temp_color == "W" ? "B" : "W"; // 색깔 변경
				}
				start_color = start_color == "W" ? "B" : "W"; // 다음 줄 시작색깔 변경
			}
			
			result = Math.min(result, sum);
	}
}


