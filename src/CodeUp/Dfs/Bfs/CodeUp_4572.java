package CodeUp.Dfs.Bfs;

import java.io.*;
import java.util.*;

public class CodeUp_4572 {
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
		
		MAP = new int[N][M];
		visitied = new boolean[N][M];
		for(int i=0; i<K; i++) {
			strSplit = br.readLine().split(" ");
			int x1 = Integer.parseInt(strSplit[0]);
			int y1 = Integer.parseInt(strSplit[1]);
			int x2 = Integer.parseInt(strSplit[2]);
			int y2 = Integer.parseInt(strSplit[3]);
			
			for(int j=x1; j<x2; j++) {
				for(int z=y1; z<y2; z++) {
					MAP[j][z] = 1;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(MAP[i][j] == 0 && visitied[i][j] == false) {
					pq.add(bfs(i,j));					
				}
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visitied[x][y] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0; i<4; i++) {
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				
				// 범위확인
				if(new_x>=0 && new_x<MAP.length && new_y>=0 && new_y<MAP[0].length) {
					if(visitied[new_x][new_y] == false && MAP[new_x][new_y] == 0) {
						visitied[new_x][new_y] = true;
						q.add(new Node(new_x, new_y));
						count++;
					}
				}
			}
		}
		
		// System.out.println("개수 " + count);
		return count;
	}
	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
