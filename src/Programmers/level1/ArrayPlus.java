package Programmers.level1;
import java.io.*;

public class ArrayPlus { // ��� ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][] = {{1}, {2}};
		int arr2[][] = {{3}, {5}};
		
		solution(arr1, arr2);
	}

	private static int[][] solution(int[][] arr1, int[][] arr2) {
	// TODO Auto-generated method stub
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        // ��� ���� ũ�Ⱑ �����ϴ�
        for(int i=0; i<arr1.length; i++){
            int a[] = arr1[i]; // �ϳ��� ���� ��ȯ
            for(int j=0; j<a.length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
	}

}
