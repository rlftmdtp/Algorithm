package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_2630 {
	public static String MAP[][];
	public static int directX[] = {0, 1, 0, -1};
	public static int directY[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		MAP = new String[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				MAP[i][j] = str.charAt(j) + "";
			}
		}
		
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(MAP[i][j].equals("1")) {
					count++;
					list.add(bfs(i, j));
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		// System.out.println("x " + x  + " y " + y + " MAP[x][y] =  "+MAP[x][y]);
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		MAP[x][y] = "0";
		int result = 1;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			
			for(int i=0; i<4; i++) {
				int newX = pos.x + directX[i];
				int newY = pos.y + directY[i];
				
				if(newX >= 0 && newX < MAP.length && newY >= 0 && newY < MAP.length) { // 범위 확인
					if(MAP[newX][newY].equals("1")) {
						MAP[newX][newY] = "0";
						q.add(new Pos(newX, newY));
						result++;
					}
				}
			}
		}
		
		return result;
	}

}

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}