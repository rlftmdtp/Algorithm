package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_7576 {
	public static int MAP[][];
	public static int distance[][];
	public static int directX[] = {0,1,0,-1};
	public static int directY[] = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int M = Integer.parseInt(strSplit[0]);
		int N = Integer.parseInt(strSplit[1]);
		MAP = new int[N][M];
		distance = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		
		for(int i=0; i<N; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<strSplit.length; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
				// System.out.print(MAP[i][j]);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(MAP[i][j] == 1) {
					result = Math.min(result, bfs(i,j));
				}
			}
		}
		
		
		System.out.println(result);
	}
	
	public static int bfs(int x, int y) {
	  	Queue<Posi> q = new LinkedList<>();
	  	q.add(new Posi(x, y));
	  	distance[x][y] = 0;
	  	
	  	int dis = 0;
		while (!q.isEmpty()) {
			Posi p = q.poll();

			for (int i = 0; i < 4; i++) {
				int newX = p.x + directX[i];
				int newY = p.y + directY[i];

				if (newX >= 0 && newX < MAP.length && newY >= 0 && newY < MAP[0].length) {
					if (MAP[newX][newY] == 0) {
						if (distance[newX][newY] > distance[p.x][p.y] + 1) {
							distance[newX][newY] = distance[p.x][p.y] + 1;
							dis = distance[p.x][p.y] + 1;
							q.add(new Posi(newX, newY));
						}
					}else {
						distance[newX][newY] = 0;
					}
				}
			}
		}
		
		return dis;
	}
	
}



class Posi{
	int x;
	int y;
	public Posi(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

