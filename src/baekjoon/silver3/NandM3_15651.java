package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class NandM3_15651 {
	public static int N;
	public static int M;
	public static List<Integer> list = new ArrayList<>();
	public static boolean visitied[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		N = Integer.parseInt(strSplit[0]);
		M = Integer.parseInt(strSplit[1]);
		visitied = new boolean[N];
		for(int i=0; i<N; i++) {
			list.add(i+1);
			perm(0, M-1);
			list.remove(list.size()-1);
		}
	}
	
	public static void perm(int depth, int r) {
		if(r == 0) {
			// Ãâ·Â
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}else if(depth == N) return;
		else {
			for(int i=0; i<N; i++) {
				visitied[i] = false;
				list.add(i+1);
				perm(depth+1, r-1);
				list.remove(list.size()-1);
				visitied[i] = true;
			}
		}
	}

}
