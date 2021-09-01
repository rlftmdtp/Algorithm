package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class NandM2 {
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String split[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(split[0]);
		int r = Integer.parseInt(split[1]);

		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = i+1;
		}
		
		combi(array, r, 0);
	}

	private static void combi(int[] array, int r, int depth) {
		// TODO Auto-generated method stub
		if(r == 0) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}else if(depth == array.length) {
			return;
		}
		else {
			list.add(array[depth]);
			combi(array, r-1, depth+1); // 선택 했을 시 
			
			list.remove(list.size()-1);
			combi(array, r, depth+1);	// 선택 안 했을 시
		}
	}

}
