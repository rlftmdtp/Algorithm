package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4697 {
	public static int direct_x[] = {0,1,0,-1};
	public static int direct_y[] = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MAP[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		int result = 0;
		for(int i=1; i<100; i++) {
			// int temp[][] = MAP.clone(); 다차원 배열은 안됨
			int temp[][] = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int z=0; z<N; z++) {
					temp[j][z] = MAP[j][z];
				}
			}
			// System.out.println("before " + temp[0][0]);
			rain(temp, i);
			// System.out.println("after " + temp[0][0]);
			
			boolean visitied[][] = new boolean[temp.length][temp.length];
			int count = 0;
			for(int j=0; j<N; j++) {
				for(int z=0; z<N; z++) {
					if(temp[j][z] > 0 && visitied[j][z] == false) count += bfs(j,z, temp, visitied);
				}
			}
			
			result = Math.max(result, count);
		}
		System.out.println(result);
		
	}
	
	// 최대 몇개 구역인지 반환
	public static int bfs(int x, int y, int temp[][], boolean visitied[][]) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visitied[x][y] = true;

		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0; i<4; i++) {
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				
				if(new_x>=0 && new_x<temp.length && new_y>=0 && new_y<temp.length) {
					if(temp[new_x][new_y] > 0 && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Node(new_x, new_y));
					}
				}
			}
		}
		
		return 1;
	}
	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void rain(int temp[][] , int depth) {
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				temp[i][j] = temp[i][j] - depth;
			}
		}
	}

}
