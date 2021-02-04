package CodeUp.Recursion;

import java.io.*;

public class CodeUp_3704 {
	//public static int memorization[]; // �޸����̼�
	public static void main(String[] args) throws NumberFormatException, IOException { // ��� ������ 2
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//memorization = new int[n+1];
		
		int result = upStair(n);
		System.out.println(result);
	}

	private static int upStair(int n) {
		// TODO Auto-generated method stub
		int stair[];
		if(n>3) stair = new int[n+1];
		else stair = new int [4];
		
		stair[1] = 1;
		stair[2] = 2;
		stair[3] = 4;
		
		// Dynamic ���
		for(int i=4; i<=n; i++) {
			stair[i] = (stair[i-1] + stair[i-2] + stair[i-3]) % 1000;
		}
		return stair[n];
		/* ����Լ��� �޸����̼� �κ� ���ÿ����÷ο�� ����
		 * if(n == 1) return 1; else if(n == 2) return 2; else if(n == 3) return 4; else
		 * if(memorization[n] != 0) return memorization[n]; else { return
		 * memorization[n] = (upStair(n-1) + upStair(n-2) + upStair(n-3))%1000; }
		 */
	}

}
