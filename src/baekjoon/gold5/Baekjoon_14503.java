package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_14503 {
	public static int MAP[][];
	public static boolean visitied[][];
	public static int direct[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		MAP = new int[N][M];
		visitied = new boolean[N][M];
		
		strSplit = br.readLine().split(" ");
		int r = Integer.parseInt(strSplit[0]);
		int c = Integer.parseInt(strSplit[1]);
		int d = Integer.parseInt(strSplit[2]);
		
		for(int i=0; i<N; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<strSplit.length; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
						
			}
		}
		
		int result = bfs(r, c, d, MAP);
		System.out.println(result);
	}
	
	public static int bfs(int x, int y, int d, int[][] MAP) {
		visitied[x][y] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x,y,d,0));

		int count = 1;
		while(!q.isEmpty()) {
			Pos p = q.poll();

			int new_x = p.x + direct[p.d][0];
			int new_y = p.y + direct[p.d][1]; 
						
			// 맵 범위
			if(new_x >=0 && new_x < MAP.length && new_y >= 0 && new_y <MAP[0].length) {
				// 아직 청소하지않은 빈 공간
				if(MAP[new_x][new_y] == 0 && visitied[new_x][new_y] == false) {
					visitied[new_x][new_y] = true;
					count++;
					q.add(new Pos(new_x, new_y, getDirect(p.d, 1), 0));
					System.out.println(new_x + " " + new_y + " count = " +  count);
				}else if(p.stack == 4) {
					// 2-b 인 경우
						// 바로 뒤쪽이 벽이라면 작동을 멈춘다
						int back = getDirect(p.d, 2);
						new_x = p.x + direct[back][0];
						new_y = p.y + direct[back][1];
						
						// 뒤쪽이 벽이 아닐 떄만 후진
						if(MAP[new_x][new_y] == 0) q.add(new Pos(new_x, new_y, p.d, 0));
				}
				else{
					// 제자리에서 왼쪽 방향 회전
					q.add(new Pos(p.x, p.y, getDirect(p.d, 1), p.stack+1));
				}
			}
		}
		return count;
	}
	
	public static int getDirect(int d, int count) {
		for(int i=0; i<count; i++) {
			if(d-1 == -1) d = 3;
			else d = d-1;
		}
		return d;
	}
	
	public static class Pos{
		int x;
		int y;
		int d;
		int stack;
		
		public Pos(int x, int y, int d, int stack){
			this.x = x;
			this.y = y;
			this.d = d;
			this.stack = stack;
		}
	}

}
