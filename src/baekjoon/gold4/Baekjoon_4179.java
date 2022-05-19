package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Baekjoon_4179 {
	public static int peopleTime[][];
	public static int fireTime[][];
	public static int directX[] = {0, 1, 0, -1};
	public static int directY[] = {1, 0, -1, 0};
	
	public static class Position{
		int x;
		int y;
		int time;
		
		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		int x = Integer.parseInt(strSplit[0]);
		int y = Integer.parseInt(strSplit[1]);
		
		char map[][] = new char[x][y];
		fireTime = new int[x][y];
		peopleTime = new int[x][y];
		
		for(int i=0; i<x; i++) {
			Arrays.fill(fireTime[i], -1);
		}
		
		
		int people_x = 0, people_y = 0, fire_x = 0, fire_y = 0;
		for(int i=0; i<x; i++) {
			String row = br.readLine();
			for(int j=0; j<y; j++) {
				map[i][j] = row.charAt(j);
				if(row.charAt(j) == 'J') {
					people_x = i;
					people_y = j;
				}
				
				if(row.charAt(j) == 'F') {
					fire_x = i;
					fire_y = j;
				}
			}
		}
		
		// ���� �̵��� �ð��� ���� ���Ѵ�
		fireBfs(fire_x, fire_y, map);
		// ���� �ð��� �������� ����� �̵��Ѵ�
		peopleBfs(people_x, people_y, map);
		// ���� �ڸ��� Ȯ���Ͽ� ���� Ȯ��
		int result = traverse();
		if(result == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(result);
	}
	
	public static int traverse() {
		// ��� �����ڸ� Ȯ��
		int result = 0;
		for(int i=0; i<peopleTime[0].length; i++) {
			result = Math.max(result, peopleTime[0][i]);
		}
		
		for(int i=0; i<peopleTime.length; i++) {
			result = Math.max(result, peopleTime[i][peopleTime[0].length-1]);
		}
		
		for(int i=0; i<peopleTime[0].length; i++) {
			result = Math.max(result, peopleTime[peopleTime.length-1][i]);
		}
		
		for(int i=0; i<peopleTime.length; i++) {
			result = Math.max(result, peopleTime[i][0]);
		}
		
		return result;
	}
	
	public static void peopleBfs(int x, int y, char map[][]) {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x,y,1));
		peopleTime[x][y] = 1;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			// 4�� ����
			for(int i=0; i<4; i++) {
				int new_x = p.x + directX[i];
				int new_y = p.y + directY[i];
				
				// ���� ũ�� Ȯ��
				if(new_x >=0 && new_x<map.length && new_y>=0 && new_y<map[0].length) {
					// System.out.println("  fireTime[new_x][new_y] " +  fireTime[new_x][new_y] + " new_x " + new_x + " new_y " + new_y);
					if(map[new_x][new_y] == '.' && p.time < fireTime[new_x][new_y]) { // ���̸� ���� ���� �������� �ð�
						peopleTime[new_x][new_y] = p.time + 1;
						q.add(new Position(new_x, new_y, p.time+1));
					}
				}
			}
		}
	}
	
	public static void fireBfs(int x, int y, char map[][]){
		// ���� ������ �ð����� ���Ѵ�
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y, 1));
		fireTime[x][y] = 1;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			// 4�� ����
			for(int i=0; i<4; i++) {
				int new_x = p.x + directX[i];
				int new_y = p.y + directY[i];
				
				// ���� ũ�� Ȯ��
				if(new_x >=0 && new_x<map.length && new_y>=0 && new_y<map[0].length) {
					// System.out.println(" new_x " + new_x + " new_y " + new_y + " p.time " + p.time);
					if(map[new_x][new_y] == '.' && fireTime[new_x][new_y] == -1) { // ���̸� ���� ���� �� �� ��
						fireTime[new_x][new_y] = p.time + 1;
						q.add(new Position(new_x, new_y, p.time+1));
					}
				}
			}
		}
	}

}
