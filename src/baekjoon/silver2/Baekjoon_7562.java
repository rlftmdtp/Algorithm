package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_7562 {
	public static int MAP[][];
	public static boolean visitied[][];
	public static int nightX;
	public static int nightY;
	public static int dirextX[] = {-2,-1,1,2,2,1,-1,-2};
	public static int dirextY[] = {1,2,2,1,-1,-2,-2,-1};
	public static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int len = Integer.parseInt(br.readLine());
			MAP = new int[len][len];
			visitied = new boolean[len][len];
			
			String strSplit[] = br.readLine().split(" ");
			int startX = Integer.parseInt(strSplit[0]);
			int startY = Integer.parseInt(strSplit[1]);
			
			strSplit = br.readLine().split(" ");
			nightX = Integer.parseInt(strSplit[0]);
			nightY = Integer.parseInt(strSplit[1]);
			bfs(new Chess(startX, startY, 0));
		}
		
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	public static void bfs(Chess chess) {
		Queue<Chess> q = new LinkedList<>();
		q.add(chess);
		visitied[chess.x][chess.y] = true;
		
		while(!q.isEmpty()) {
			Chess ch = q.poll();
			
			if(ch.x == nightX && ch.y == nightY) {
				result.add(ch.distnace);
				break;
			}
			
			for(int i=0; i<8; i++) {
				int newX = ch.x + dirextX[i];
				int newY = ch.y + dirextY[i];
				
				if(newX>=0 && newX<MAP.length && newY>=0 && newY<MAP.length) {
					if(visitied[newX][newY] == false) {
						visitied[newX][newY] = true;
						q.add(new Chess(newX, newY, ch.distnace+1));
					}
				}
			}
		}
	}

}

class Chess{
	int x;
	int y;
	int distnace;
	
	public Chess(int x, int y, int distnace) {
		this.x = x;
		this.y = y;
		this.distnace = distnace;
	}
}

