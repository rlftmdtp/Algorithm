package CodeUp.backtracking;

import java.io.*;
import java.util.*;

public class CodeUp_2608 {
	public static String list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new String[N];
		// �������� �˾����� ����?
		combi(N,0);
	}
	
	public static void combi(int n, int depth) {
		if(depth == n) {
			// ���� �Ϸ�
			for(int i=0; i<list.length; i++) {
				System.out.print(list[i]);
			}
			System.out.println();
		}else {
			list[depth] = "O";
			combi(n, depth+1); // ����
			
			list[depth] = "X";
			combi(n, depth+1); // �̼���
		}
	}

}
