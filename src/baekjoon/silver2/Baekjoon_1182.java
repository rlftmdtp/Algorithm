package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_1182 {
	public static int list[];
	public static int SUM;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int S = Integer.parseInt(strSplit[1]);
		list = new int[N];
		SUM = S;
		strSplit = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		// 합이 0 일 경우 공집합도 포함이 되므로 이떄는 제외
		int result = dfs(0, 0);
		System.out.println(S == 0 ? result-1 : result);
	}
	
	public static int dfs(int sum, int depth) {

		if(depth == list.length) {
			if(sum == SUM) return 1;
		}else {
			return dfs(sum+list[depth], depth+1)+dfs(sum, depth+1);
		}
		return 0;
	}

}
