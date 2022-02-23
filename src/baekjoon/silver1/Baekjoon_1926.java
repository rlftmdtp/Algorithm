package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_1926 {
	public static boolean visitied[][];
	public static int directX[] = {0, 1, 0, -1};
	public static int directY[] = {1, 0, -1, 0};
	
	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int x = Integer.parseInt(strSplit[0]);
		int y = Integer.parseInt(strSplit[1]);
		
		int map[][] = new int[x][y];
		visitied = new boolean[x][y];
		
		for(int i=0; i<x; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<y; j++) {
				map[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// 그림의 개수, 가장 넓은 그림의 넓이
		int count = 0;
		int max = 0;
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(visitied[i][j] == false && map[i][j] == 1) {
					count++;
					max = Math.max(max, bfs(i,j,map));
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}
	
	public static int bfs(int x, int y, int map[][]) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visitied[x][y] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// 가로 세로 방향
			for(int i=0; i<4; i++) {
				int new_x = p.x + directX[i];
				int new_y = p.y + directY[i];
				
				// 맵의범위
				if(new_x>=0 && new_x < map.length && new_y>=0 && new_y < map[0].length) {
					if(map[new_x][new_y] == 1 && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Point(new_x, new_y));
						count++;
 					}
				}
			}
		}
		// System.out.println("bfs() count = " + count);
		return count;
	}

}
