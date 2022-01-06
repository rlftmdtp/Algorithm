package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_1992 {
	public static int MAP[][];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				MAP[i][j] = str.charAt(j) - '0';
			}
		}
	
		quardTree(0,0,N,N);
		System.out.println(sb.toString());
	}
	
	public static void quardTree(int sx, int sy, int ex, int ey) {
		int start = MAP[sx][sy];
		boolean flag = true;
		
		for(int i=sx; i<ex; i++) {
			for(int j=sy; j<ey; j++) {
				if(start != MAP[i][j]) flag = false;
			}
		}
		
		
		if(flag) {
			// System.out.println("start " + start);
			sb.append(start);
		
		}
		else {
			int d = (ex-sx)/2;
			sb.append("(");
			quardTree(sx, sy, sx+d, sy+d);
			quardTree(sx, sy+d, sx+d, ey);
			quardTree(sx+d, sy, ex, sy+d);
			quardTree(sx+d, sy+d, ex, ey);
			sb.append(")");
		}
		
	}


}
