package CodeUp.Dfs.Bfs;

import java.util.*;
import java.io.*;

public class CodeUp_4024 {
	public static int direct_x[] = {-1,-1,0,1,1,1,0,-1};
	public static int direct_y[] = { 0, 1,1,1,0,-1,-1,-1};
	public static boolean visitied[][];
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
		
		int W = Integer.parseInt(strSplit[0]);
		int H = Integer.parseInt(strSplit[1]);
		
		String MAP[][] = new String[H][W];
		visitied = new boolean[H][W];
		for(int i=0; i<H; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<W; j++) {
				MAP[i][j] = strSplit[j];
			}
		}
		
		// 호수의 개수를 구하여라
		int result = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(visitied[i][j] == false && MAP[i][j].equals("L")) {
					result += bfs(i, j, MAP);
				}
			}
		}
		System.out.println(result);
 	}
	
	public static int bfs(int x, int y, String MAP[][]) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			// 상, 하, 좌, 와, 대각선
			for(int i=0; i<8; i++) {
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				
				// 맵의 크기
				if(new_x >= 0 && new_x < MAP.length && new_y >= 0 && new_y < MAP[0].length) {
					if(MAP[new_x][new_y].equals("L") && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Node(new_x, new_y));
					}
				}
			}
		}
		
		
		return 1;
	}

}
