package Programmers.level1;

import java.io.*;

public class GymClothes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String strSplit[] = br.readLine().split("\\s");
		int lost[] = new int[strSplit.length];
		for(int i=0; i<strSplit.length; i++) {
			lost[i] = Integer.parseInt(strSplit[i]);
		}
		
		strSplit = br.readLine().split("\\s");
		int reserve[] = new int[strSplit.length];
		for(int i=0; i<strSplit.length; i++) {
			reserve[i] = Integer.parseInt(strSplit[i]);
		}
		System.out.println(solution(n, lost, reserve));
	}

	private static int solution(int n, int[] lost, int[] reserve) {
		// TODO Auto-generated method stub
		int answer = 0;
		int count = 0;
		for(int i=0; i<lost.length; i++) {
			int k = lost[i];
			for(int j=0; j<reserve.length; j++) {
				if(reserve[j] != 0) {
					if(k==reserve[j]-1 || k==reserve[j]+1) {
						count++;
						reserve[j] = 0; // 옷을 소모함
						break;
					}else if(k==reserve[j]) { // 여벌 체육복을 가져온 학생이 도난당함
						reserve[j] = 0;
						break;
					}
				}
			}
		}
		return n-lost.length+count;
	}

}
