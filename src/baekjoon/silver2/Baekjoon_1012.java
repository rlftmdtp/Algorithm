package baekjoon.silver2;

import java.util.*;
import java.io.*;

public class Baekjoon_1012 {
	public static int MAP[][];
	public static int directX[] = {0, 1 ,0 , -1};
	public static int directY[] = {1, 0,-1 ,  0};
	public static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		List<Integer> result = new ArrayList<>();
		for(int c=0; c<T; c++) {
			String strSplit[] = br.readLine().split(" ");
			N = Integer.parseInt(strSplit[0]);
			M = Integer.parseInt(strSplit[1]);
			int K = Integer.parseInt(strSplit[2]);
			
			MAP = new int[N][M];
			// ¹èÃß 1
			for(int i=0; i<K; i++) {
				strSplit = br.readLine().split(" ");
				int x = Integer.parseInt(strSplit[0]);
				int y = Integer.parseInt(strSplit[1]);
				
				MAP[x][y] = 1;
			}
			
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(MAP[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			result.add(count);
		}
		
		for(int n : result) {
			System.out.println(n);
		}
	}
	
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		MAP[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i=0; i<4; i++) {
				int newX = pos.x + directX[i];
				int newY = pos.y + directY[i];
				
				if(newX >=0 && newX < N && newY >= 0 && newY < M) {
					if(MAP[newX][newY] == 1) {
						MAP[newX][newY] = 0;
						q.add(new Pos(newX, newY));
					}
				}
			}
		}
		
	}

}

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
