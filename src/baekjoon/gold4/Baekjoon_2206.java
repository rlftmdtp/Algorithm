package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Baekjoon_2206 {
	public static int MAP[][];
	public static boolean visitied[][][];
	public static int directX[] = {0,1,0,-1};
	public static int directY[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		MAP = new int[N][M];
		visitied = new boolean[N][M][2]; // 0 : �ν����� ����, 1 : �ѹ� �ν����� ����
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				MAP[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = bfs(0,0);
		System.out.println(result);
	}
	
	public static int bfs(int x,  int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,1,1));
		visitied[x][y][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.x == visitied.length-1 && n.y == visitied[0].length-1) { // ���� ó�� ����
				return n.count;
			}
			
			for(int i=0; i<4; i++) {
				int next_x = n.x + directX[i];
				int next_y = n.y + directY[i];
				
				if(next_x>=0 && next_x<MAP.length && next_y>=0 && next_y<MAP[0].length) {
					if(MAP[next_x][next_y] == 0) { // ���� ��� - ���� �Ȼѽð� �°���, �ѽð� �� ��찡 �ִ�
						if(visitied[next_x][next_y][0] == false && n.destory == 1) { // ���� �湮������ ���� ��
							visitied[next_x][next_y][0] = true;
							q.add(new Node(next_x, next_y, n.count+1,1));
						}
						
						if(visitied[next_x][next_y][1] == false && n.destory == 0) {
							visitied[next_x][next_y][1] = true;
							q.add(new Node(next_x, next_y, n.count+1, 0));
						}
					}else if(MAP[next_x][next_y] == 1) { // ���� ���
						if(visitied[next_x][next_y][1] == false && n.destory == 1) {
							visitied[next_x][next_y][1] = true;
							q.add(new Node(next_x, next_y, n.count+1, 0));
						}
					}
				}
			}
		}
		return -1;
	}

}

class Node{
	int x;
	int y;
	int count;
	int destory;
	
	public Node(int x, int y, int count, int destory) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.destory = destory;
	}
}
