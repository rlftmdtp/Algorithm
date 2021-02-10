package CodeUp.Recursion;

import java.io.*;

public class CodeUp_2748 { // ����, �������� n�����
	public static int M;
	public static int N;
	public static int list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		String strSplit[] = br.readLine().split("\\s");
		
		list = new int[N];
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		int sum = 0;
		System.out.println(findZero(sum, 0));
	}

	private static int findZero(int sum, int start) {
		// TODO Auto-generated method stub
		// ��������� ���ప plus�� ���� minus�� ���� ������  f(n) = f(n-1)�÷����ǰ�� + ���簪
		//                                            f(n) = f(n-1)���̳ʽ��ǰ�� + ���簪
		int result = 0;
		if(sum == M) {
			System.out.println("sum == M " + sum);
			return 1;
		}else if(start >= N) { System.out.println("start >= N " + sum + " " + start);
			return 0;
		}
		else {
			for(int i=start; i<N; i++) {
				System.out.println("sum " + sum + " start " + start);
				result += findZero(sum + list[i], i+1);		
				System.out.println("������");
				result += findZero(sum - list[i], i+1); // ���̳ʽ� ���
			}
		}
		return result;
	}
	
	// ���� ���� -�ΰ�� +�� ��ȯ ( ex. -1 - (-1))
	private static int sumMethod(int a, int b) {
		if(b<0) {
			b = b*-1;
		}
		return a+b;
	}

}
