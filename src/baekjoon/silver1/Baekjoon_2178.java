package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_2178 {
	public static int MAP[][];
	public static boolean visitied[][];
	public static int directX[] = {0,1,0,-1};
	public static int directY[] = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		MAP = new int[N][M];
		visitied = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<M; j++) {
				MAP[i][j] = row.charAt(j) - '0';
			}
		}
		
		// 1만 이동할 수 있으며 최소거리를 구한다 => bfs
		int result = bfs(new Position(0,0,0));
		System.out.println(result);
	}
	
	public static int bfs(Position pos) {
		Queue<Position> q = new LinkedList<>();
		q.add(pos);
		visitied[pos.x][pos.y] = true;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			for(int i=0; i<4; i++) {
				int newX = p.x + directX[i];
				int newY = p.y + directY[i];
				
				// 끝에 도달 (bfs는 최초에 도달했을 시 최단거리이다 => dfs보다 빠른 이유)
				if(newX == MAP.length-1 && newY == MAP[0].length) {
					return p.distance+1;
				}
				
				if(newX>=0 && newX<MAP.length && newY>=0 && newY<MAP[0].length) {
					if(MAP[newX][newY] == 1 && visitied[newX][newY] == false) { // 길이며 방문한 적이 없을 때
						visitied[newX][newY] = true;
						q.add(new Position(newX, newY, p.distance+1));
					}
				}
			}
		}
		return -1;
	}

}

class Position{
	int x;
	int y;
	int distance;
	
	public Position(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
