package CodeUp.Dfs.Bfs;

import java.util.*;
import java.io.*;

public class CodeUp_3500 {
	public static int direct_x[] = {-1,-1,0,1,1,1,0,-1};
	public static int direct_y[] = { 0, 1,1,1,0,-1,-1,-1};
	public static String result[][] = new String[9][9];
	public static boolean visitied[][] = new boolean[9][9];
	
	public static class Mine{
		int x;
		int y;
		
		public Mine(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String map[][] = new String[9][9];
		// 9 9
		for(int i=0; i<9; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				map[i][j] = strSplit[j];
			}
		}
		
		for(int i=0; i<9; i++) {
			Arrays.fill(result[i], "_");
		}
		
		String strSplit[] = br.readLine().split(" ");
		int r = Integer.parseInt(strSplit[0]);
		int c = Integer.parseInt(strSplit[1]);
		
		// 해당 점에서 시작
		bfs(r-1, c-1, map);
		for(int i=0; i<9; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<9; j++) {
				sb.append(result[i][j] + " ");
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void bfs(int x, int y, String map[][]) {
		// 고른 칸 확인
		if(map[x][y].equals("1")) {
			result[x][y] = "-1";
			return;
		}
		
		Queue<Mine> q = new LinkedList<>();
		q.add(new Mine(x,y));
		while(!q.isEmpty()) {
		    Mine m = q.poll();
		    
			// 주변 8개를 확인 후 주변에 지뢰가 없으면 다음 이동, 지뢰가 있으면 현재 위치에 지뢰갯수
		    int mime_count = 0;
			for(int i=0; i<8; i++) {
				int new_x = m.x + direct_x[i];
				int new_y = m.y + direct_y[i];
				
				// 맵의 범위 확인
				if(new_x>=0 && new_x<9 && new_y>=0 && new_y<9) {
					if(map[new_x][new_y].equals("1")) mime_count++;
				}
			}
			
			visitied[m.x][m.y] = true;
			if(mime_count > 0) { // 현재 자리에 지뢰갯수를 넣고 종료
				result[m.x][m.y] = Integer.toString(mime_count);
			}else {
				result[m.x][m.y] = "0";
				// 다음 이동위치 넣기
				for(int i=0; i<8; i++) {
					int new_x = m.x + direct_x[i];
					int new_y = m.y + direct_y[i];
					
					// 맵의 범위 확인
					if(new_x>=0 && new_x<9 && new_y>=0 && new_y<9) {
						if(visitied[new_x][new_y] == false) q.add(new Mine(new_x, new_y));
					}
				}
			}
		}
	}

}
