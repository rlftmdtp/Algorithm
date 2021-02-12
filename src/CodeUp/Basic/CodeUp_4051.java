package CodeUp.Basic;

import java.io.*;


public class CodeUp_4051 { // 시간 외 근무수당

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float time = 0;
		for(int i=0; i<5; i++) {
			String strSplit[] = br.readLine().split("\\s");
			float start = Float.parseFloat(strSplit[0]);
			float end = Float.parseFloat(strSplit[1]);
			time += calculTime(end-start);
		}
		System.out.println(calculMoney(time));
	}

	private static int calculMoney(float time) {
		// TODO Auto-generated method stub
		int money = 0;
		System.out.println("time " + time);
		if(time%1 == 0) money = (int)(time * 2 * 5000); // 30분이 존재하지 않는 경우
		else money = (int)((time-0.5) * 2 * 5000 + 5000); // 30분이 존재하는 경우 시간 계산을 30분을 제외시켜놓고 *2후 따로 더한다
		
		System.out.println("money " + money);
		// 총 시간외 수당에 따른 계산법 적용
		if(time >= 15) money -= money*0.05;
		else if(time <= 5) money += money*0.05;
		
		return money;
	}

	private static float calculTime(float n) {
		// TODO Auto-generated method stub
		if(n <= 1) return 0;
		else if(n >= 5) return 4;
		else return n-1;
	}

}
