package CodeUp.backtracking;

import java.io.*;
import java.util.*;

public class CodeUp_3515 {
	public static int result = 0;
	public static int visitied[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int list[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				list[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// ����Ž��
		// �� ��� ���� �������� ������ �ִµ�, �� ��� ���� ��ġ�� �ʰ� ������ ��������.
		visitied = new int[N]; // �࿡ ���� �� �ִ�
		Arrays.fill(visitied, -1);
		dfs(list, 0, 0);
		System.out.println(result);
	}
	
	public static void dfs(int list[][], int sum, int depth) {
		if(depth == list.length) {
			result = Math.max(result, sum);
		}else {
			// �ش� ���� �ϳ��� ����
			for(int i=0; i<list.length; i++) {
				if(visitied[depth] == -1) {

					// �� Ȯ��
					if(checkRow(i)) {
						// System.out.println("������ �� " + depth);
						// System.out.println("������ ��" + i);
						visitied[depth] = i;
						dfs(list, sum + list[depth][i], depth+1);
						visitied[depth] = -1;
					}
				}
			}
			
		}
		
	}
	
	public static boolean checkRow(int index) {
		// �̹� ������ ���� ��� �Ұ�
		for(int i=0; i<visitied.length; i++) {
			if(visitied[i] == index) return false;
		}
		return true;
	}

}
