package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_7569 {
	public static int MAP[][][];
	public static int directX[] = {0,1,0,-1,0,0};
	public static int directY[] = {1,0,-1,0,0,0};
	public static int directZ[] = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int M = Integer.parseInt(strSplit[0]);
		int N = Integer.parseInt(strSplit[1]);
		int H = Integer.parseInt(strSplit[2]);
		MAP = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				strSplit = br.readLine().split(" ");
				for(int k=0; k<M; k++) {
					MAP[i][j][k] = Integer.parseInt(strSplit[k]);
				}
			}
		}
		
		// 각 층별로 검사해야한다
		Queue<Tomato> q = new LinkedList<>();
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(MAP[i][j][k] == 1) q.add(new Tomato(i,j,k));
				}
			}
		}
		
		bfs(q);
		
		// 결과
		int result = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(MAP[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
					
					result = Math.max(result, MAP[i][j][k]);
				}
			}
		}
		System.out.println(result-1);
	}

	public static void bfs(Queue<Tomato> q) {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			
			for(int i=0; i<6; i++) {
				int newZ = t.z + directZ[i];
				int newX = t.x + directX[i];
				int newY = t.y + directY[i];
				
				if(newX>=0 && newX<MAP[0].length && newY>=0 && newY<MAP[0][0].length && newZ>=0 && newZ<MAP.length) {
					if(MAP[newZ][newX][newY] == 0) {
						MAP[newZ][newX][newY] = MAP[t.z][t.x][t.y] + 1;
						q.add(new Tomato(newZ, newX, newY));
					}
				}
			}
		}
	}
	
}

class Tomato{
	int z;
	int x;
	int y;
	public Tomato(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
}