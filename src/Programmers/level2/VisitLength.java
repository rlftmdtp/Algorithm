package Programmers.level2;

import java.util.*;

public class VisitLength {
	public static int result = 0;
	public static List<Pos> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(String dirs) {
		dfs(0,0,0,dirs);
		return result;
	}
	
	public static void dfs(int x, int y, int depth, String dirs) {
		if(dirs.length() == depth) return;
		else {
			char d = dirs.charAt(depth);
			
			int nextX = x;
			int nextY = y;
			if(d == 'U') nextY++;
			else if(d == 'D') nextY--;
			else if(d == 'L') nextX--;
			else nextX++;
			
			// 범위 널으면 무시
			if(nextX >= 6 || nextX <=-6 || nextY >= 6 || nextY <= -6) {
				dfs(x,y,depth+1,dirs);
			}else {
				if(firstLine(nextX, x, nextY, y)) result++;
				
				list.add(new Pos(x,y, nextX, nextY));
				dfs(nextX, nextY, depth+1, dirs);
			}
		}
	}
	
	public static boolean firstLine(int nextX, int x, int nextY, int y) {
		for(Pos p : list) {
			if(p.toX == nextX && p.fromX == x && p.toY == nextY && p.fromY == y) return false;
		}
			return true;
	}
	
	public static class Pos{
		int fromX;
		int fromY;
		int toX;
		int toY;
		
		public Pos(int fromX, int fromY, int toX, int toY) {
			this.fromX = fromX;
			this.fromY = fromY;
			this.toX = toX;
			this.toY = toY;
		}
	}

}
