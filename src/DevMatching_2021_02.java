import java.io.*;
import java.util.*;
import java.util.regex.*;

import baekjoon.gold2.Baekjoon_11779.Node;


public class DevMatching_2021_02 {
	
	public static int MAP[][];
	public static int direct_x[] = {0,1,1,1,0,-1,-1,-1};
	public static int direct_y[] = {1,1,0,-1,-1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// int n = 3;
//		String[] recipies = {"A 3", "B 2"};
//		String[] orders = {"A 1", "A 2", "B 3", "B 4"};
		
		int h = 7;
		int w = 9;
		int n  = 4;
		String board[] = {"111100000", "000010011" , "111100011" , "111110011", "111100011" , "111100010" , "111100000"};
		solution(h, w, n, board);
	}
	
	public static int solution(int h, int w, int n, String[] borad){
		
		MAP = new int[h][w];
		for(int i=0; i<h; i++) {
			String str = borad[i];
			for(int j=0; j<w; j++) {
				MAP[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int result = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(MAP[i][j] == 1) result += bfs(i,j,n);
			}
		}
		System.out.println("최종 정답 " + result);
		return result;
	}
	
	public static int bfs(int x, int y, int limit) {

		//총8개의 방향?
		int count = 0;
		for(int i=0; i<4; i++) {
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(x,y));
			int depth = 1;
			
			while(!q.isEmpty()) {
				Node n = q.poll();
			
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				// System.out.println("new_x " + new_x + " new_y " + new_y);
				if(depth == limit) { // 마지막 돌  확인
					int reverse_x = x + direct_x[i+4];
					int reverse_y = y + direct_y[i+4];
					if(new_x >= 0 && new_x<MAP.length && new_y >=0 && new_y < MAP[0].length &&
							reverse_x >= 0 && reverse_x<MAP.length && reverse_y >=0 && reverse_y < MAP[0].length) { // 범위 확인
						if(MAP[new_x][new_y] == 0 && MAP[reverse_x][reverse_y] == 0) { // 양쪽 끝으로 더 있는지 확인해야 한다
							count++;
							System.out.println("new_x " + new_x + " new_y " + new_y + " i방향 " + i);
						}
					}else {
						count++;
						System.out.println("new_x " + new_x + " new_y " + new_y + " i방향 " + i);
					}
				}
				
				if(new_x >= 0 && new_x<MAP.length && new_y >=0 && new_y < MAP[0].length) { // 범위 확인
					if(MAP[new_x][new_y] == 1) {
						// System.out.println("zz");
						q.add(new Node(new_x, new_y));
						depth++;
					}
				}
			}
		}
		System.out.println("X : " + x + " Y " + y + " count= " + count);
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


