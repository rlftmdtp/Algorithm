package CodeUp.Dfs.Bfs;

import java.io.*;
import java.util.*;

public class CodeUp_4060 {
	public static int MAP[][];
	public static int direct_x[] = {0,1,0,-1};
	public static int direct_y[] = {1,0,-1,0};
	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int X = Integer.parseInt(strSplit[0]);
		int Y = Integer.parseInt(strSplit[1]);
		
		MAP = new int[X][Y];
		for(int i=0; i<X; i++) {
			strSplit = br.readLine().split(" ");
			
			for(int j=0; j<strSplit.length; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// bfs를 이용하여 최소횟수 구하기 전체켜기, 전체끄기   1켜진상태, 0꺼진상태
		boolean visitied[][] = new boolean[X][Y];
		boolean visitied2[][] = new boolean[X][Y];
		int on_count = 0;
		int off_count = 0;
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				on_count += bfs(0, i,j, visitied); // 켜기
				off_count += bfs(1, i,j, visitied2); // 끄기
			}
		}
		System.out.println(on_count + " " + off_count);
	}
	
	public static int bfs(int status, int x, int y, boolean[][] visitied) {
		
		if(MAP[x][y] != status || visitied[x][y] == true) return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visitied[x][y] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i=0; i<4; i++) { // 4가지 방향
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				
				if(new_x >= 0 && new_x<MAP.length && new_y >= 0 && new_y<MAP[0].length) { // 맵 크기
					if(MAP[new_x][new_y] == status && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Node(new_x, new_y));
					}
				}
			}
		}
		
		return 1;
	}

}
