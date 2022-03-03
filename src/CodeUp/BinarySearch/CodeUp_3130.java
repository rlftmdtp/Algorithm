package CodeUp.BinarySearch;

import java.util.*;
import java.io.*;

public class CodeUp_3130 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		long sum = 0;
		for(int i=0; i<N-1; i++) { // ������ �Ҵ� Ȯ���� �� �����ϱ� �����Ѵ�
			sum += twoPointer(i, list[i], list);
		}
		System.out.println(sum);
	}
	
	public static long twoPointer(int start, int search, int list[]) {
		int end = start+1;
		long result = 0;
		while(end < list.length) {
			if(search > list[end]) end++;
			else {
				break;
			}
		}
		result = end - start - 1; // �̸� ���� �������� ���⋚���� -1 �߰�
		System.out.println((start+1) + "��° �Ұ� ���� �� " + result);
		return result;
	}
}
