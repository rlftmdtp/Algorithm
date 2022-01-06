package baekjoon.silver2;

import java.util.*;
import java.io.*;

public class Baekjoon_1780 {
	public static int result[] = new int[3];
	public static int MAP[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		MAP = new int[N][N];
		for (int i = 0; i < N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}

		search(0, 0, N, N);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static void search(int sx, int sy, int ex, int ey) {

		if (count(sx, sy, ex, ey)) {
			if (MAP[sx][sy] == -1)
				result[0]++;
			else if (MAP[sx][sy] == 0)
				result[1]++;
			else
				result[2]++;
		} else {
			// 9개 모양으로 자르기
			int d = (ex - sx) / 3;
			search(sx, sy, sx + d, sy + d);
			search(sx, sy + d, sx + d, sy + 2 * d);
			search(sx, sy + 2 * d, sx + d, ey);

			search(sx+d, sy, sx+2*d, sy+d); 
			search(sx+d, sy+d, sx+2*d, sy+2*d); 
			search(sx+d, sy+2*d, sx+2*d, ey);
			  
			search(sx+2*d, sy, ex, sy+d); 
			search(sx+2*d, sy+d, ex,sy+2*d); 
			search(sx+2*d, sy+2*d, ex, ey);
			 

		}
	}

	public static boolean count(int sx, int sy, int ex, int ey) {
		int start = MAP[sx][sy];

		boolean flag = true;
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				if (start != MAP[i][j])
					flag = false;
			}
		}
		return flag;
	}

}
