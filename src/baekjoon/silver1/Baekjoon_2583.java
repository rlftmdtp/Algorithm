package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_2583 {
	public static int MAP[][];
	public static boolean visitied[][];
	public static int direct_x[] = {0,1,0,-1};
	public static int direct_y[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int M = Integer.parseInt(strSplit[0]);
		int N = Integer.parseInt(strSplit[1]);
		int K = Integer.parseInt(strSplit[2]);
		MAP = new int[M][N];
		visitied = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			strSplit = br.readLine().split(" ");
			
			int x = Integer.parseInt(strSplit[0]);
			int y = Integer.parseInt(strSplit[1]);
			int x2 = Integer.parseInt(strSplit[2]);
			int y2 = Integer.parseInt(strSplit[3]);
			
			for(int j=y; j<y2; j++) {
				for(int z=x; z<x2; z++) {
					MAP[j][z] = 1;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(MAP[i][j] == 0 && visitied[i][j] == false) {
					pq.add(bfs(i,j));
				}
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		
//		for(int i=0; i<M; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(MAP[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		visitied[x][y] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0; i<4; i++) {
				int new_x = p.x + direct_x[i];
				int new_y = p.y + direct_y[i];
				
				// ¸Ê ¹üÀ§
				if(new_x >= 0 && new_x < MAP.length && new_y >= 0 && new_y < MAP[0].length) {
					if(MAP[new_x][new_y] == 0 && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Pos(new_x, new_y));
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
