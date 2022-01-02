package CodeUp.Basic;

import java.util.*;
import java.io.*;

public class CodeUp_4746 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int A = Integer.parseInt(strSplit[0]);
		int B = Integer.parseInt(strSplit[1]);
		int C = Integer.parseInt(strSplit[2]);
		int D = Integer.parseInt(br.readLine());
		
		int time[] = new int[3];
		while(true) {
			if(D>=3600) {
				time[0] = D/3600;
				D = D%3600;
			}else if(D<3600 && D>=60) {
				time[1] = D/60;
				D = D%60;
			}else {
				time[2] = D;
				break;
			}
		}
		
		// System.out.println(time[0] + " " + time[1] + " " + time[2]);
		// 시간 더하기
		String result = timeCal(A, B, C, time);
		System.out.println(result);
	}

	private static String timeCal(int a, int b, int c, int[] time) {
		// TODO Auto-generated method stub
		// 초 부터 더하면서 앞자리 나아간다
		int next = 0;
		int h = 0, m = 0, s = 0;
		for(int i=2; i>=0; i--) {
			if(i == 2) { // 초
				s = c + time[i];
				next = s/60;
				s = s%60;
			}else if(i == 1) { // 분
				m = next + b + time[i];
				next = m/60;
				m = m%60;
			}else { // 시
				h = next + a + time[i];
				// 24시간을 계속 돌아야 한다.
				h = h%24;
			}
		}
		
		return h + " " + m + " " + s; 
	}

}
