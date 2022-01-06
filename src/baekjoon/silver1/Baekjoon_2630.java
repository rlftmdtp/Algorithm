package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_2630 {
	public static int MAP[][];
	public static int WHITE_COUNT;
	public static int BLUE_COUNT;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<strSplit.length; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		
		search(0, 0, N, N);
		System.out.println(WHITE_COUNT);
		System.out.println(BLUE_COUNT);
	}
	
	public static void search(int sx, int sy, int ex, int ey) {
		
		int color  = MAP[sx][sy];
		
		boolean flag = true;
		System.out.println("sx " + sx + " sy " + sy + " ex " + ex + " ey " + ey);
		for(int i=sx; i<ex; i++) {
			for(int j=sy; j<ey; j++) {
				System.out.println("i " + i + " j " + j);
				if(MAP[i][j] != color) flag = false;
			}
		}
		
		if(flag) {
			if(color == 0) WHITE_COUNT++;
			else BLUE_COUNT++;
		}else {
			int newN = (ex-sx)/2;
			search(sx,sy, sx+newN, sy+newN);
			search(sx, sy+newN, sx+newN, ey);
			search(sx+newN, sy, ex, sy+newN);
			search(sx+newN, sy+newN, ex, ey);
		}
	}

}
