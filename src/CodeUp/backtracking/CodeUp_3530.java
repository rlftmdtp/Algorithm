package CodeUp.backtracking;

import java.io.*;
import java.util.*;

public class CodeUp_3530 {
	public static int MAP[][] = new int[9][9];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			String strSplit[] = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(MAP[i][j] == 0) {
					if(sudoko(i,j) == false) {
						System.out.println(i + " " + j);
						System.out.println("Not Possible");
						return;
					}
				}
			}
		}
		
		// ���� ���
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static boolean sudoko(int x, int y) {
		// 1. ����Ȯ�� , 2.���� Ȯ��, 3. 3x3Ȯ��
		if(rowCheck(x,y)) return true;
		if(columnCheck(x, y)) return true;
		if(threeCheck(x, y)) return true;
		
		return false;
	}
	
	public static boolean threeCheck(int x, int y) {
		// ���� ��ġ���� 3x3 ��ġ �ľ�
		int startX = 0;
		if(x>=0 && x<=2) startX = 0;
		else if(x>=3 && x<= 5) startX = 3;
		else startX = 6;
		
		int startY = 0;
		if(y>=0 && y<=2) startY = 0;
		else if(y>=3 && y<= 5) startY = 3;
		else startY = 6;
		
		// ������ �밢������ ������ �����ؾ��Ѵ�
		// 1~9���� �˻�
		boolean check[] = new boolean[10];
		int zeroCount = 0;
		// System.out.println("startX " + startX + " startY " + startY);
		for(int i=startX; i<startX+3; i++) {
			for(int j=startY; j<startY+3; j++) {
				check[MAP[i][j]] = true;
				if(MAP[i][j] == 0) zeroCount++;
			}
		}
		
		if(zeroCount == 1) {
			insertNum(x,y, check);
			return true;
		}
		return false;
	}
	
	public static boolean columnCheck(int x, int y) {
		boolean check[] = new boolean[10];
		int zeroCount = 0;
		for(int i=0; i<9; i++) {
			check[MAP[i][y]] = true;
			if(MAP[i][y] == 0) zeroCount++;
			
		}

		if(zeroCount == 1) {
			insertNum(x,y, check);
			return true;
		}
		
		return false;
	}
	
	public static boolean rowCheck(int x, int y) {
		boolean check[] = new boolean[10];
		int zeroCount = 0;
		for(int i=0; i<9; i++) {
			check[MAP[x][i]] = true;
			if(MAP[x][i] == 0) zeroCount++;
		}
		
		if(zeroCount == 1) {
			insertNum(x,y, check);
			return true;
		}
		
		return false;
	}
	
	public static void insertNum(int x, int y, boolean check[]) {
		for(int i=1; i<10; i++) {
			if(check[i] == false) MAP[x][y] = i;
		}
	}
}
