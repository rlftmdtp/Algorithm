package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_2667 {
	public static String MAP[][];
	public static boolean visitied[][];
	public static int directX[] = {0, 1, 0, -1};
	public static int directY[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		MAP = new String[N][N];
		visitied = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				MAP[i][j] = str.charAt(j) + "";
			}
		}
		
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(MAP[i][j].equals("1")) {
					int result = bfs(i, j);
					if(result > 1) {
						count++;
						System.out.println("result " + result);
						list.add(result);
					}
				}

			}
		}
		
		System.out.println(count);
	}
	
	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		System.out.println("x " + x  + " y " + y + " MAP[x][y] =  "+MAP[x][y]);
		int result = 1;
		MAP[x][y] = "0"; // 방문 표시
		
		for(int i=0; i<4; i++) {
			int newX = x + directX[i];
			int newY = y + directY[i];
			
			
			if(newX >= 0 && newX < MAP.length && newY >= 0 && newY < MAP.length) { // 범위 확인
				
				if(MAP[newX][newY].equals("1")) result += bfs(newX, newY);
			}
		}
		return result;
	}

}
