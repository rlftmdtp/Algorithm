package CodeUp.Basic;

import java.util.*;
import java.io.*;

public class CodeUp_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int list[] = new int[5];
		for(int i=0; i<5; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		// �Ľ�Ÿ �� ���� ������
		double pasta = 2001;
		for(int i=0; i<3; i++) {
			pasta = Math.min(pasta, list[i]);
		}
		
		double juice = 2001;
		for(int i=3; i<5; i++) {
			juice = Math.min(juice, list[i]);
		}
		
		// �Ľ�Ÿ�� ������ �꽺�� ���� �հ迡�� 10%�� ���� �ݾ��� ��ݵȴ�.
		double total = pasta + juice;
		double mod = total*0.1;
		// System.out.println(mod);
		
		total += mod;
		System.out.println(total);		
	}

}
