package CodeUp.Dfs.Bfs;

import java.util.*;
import java.io.*;

public class CodeUp_1524 {
	public static int direct_x[] = {-1,-1,0,1,1,1,0,-1};
	public static int direct_y[] = { 0, 1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[9][9];
		// 9 9
		for(int i=0; i<9; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		String strSplit[] = br.readLine().split(" ");
		int r = Integer.parseInt(strSplit[0]);
		int c = Integer.parseInt(strSplit[1]);
		
		System.out.println(bfs(r-1,c-1, map));
	}
	
	public static int bfs(int x, int y, int map[][]) {
		int result = 0;
		
		// 고른 칸 확인
		if(map[x][y] == 1) return -1;
		
		// 주변에 있는 지뢰 갯수 반환 (주변 8개)
		for(int i=0; i<8; i++) {
			int nex_x = x + direct_x[i];
			int nex_y = y + direct_y[i];
			
			// 맵의 범위 확인
			if(nex_x>=0 && nex_x<9 && nex_y>=0 && nex_y<9) {
				if(map[nex_x][nex_y] == 1) result++;
			}
		}
		return result;
	}

}
