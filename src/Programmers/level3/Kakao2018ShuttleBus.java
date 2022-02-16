package Programmers.level3;

import java.util.*;

public class Kakao2018ShuttleBus {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int t = 60;
		int m = 45;
		String timetable[] = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		solution(n, t, m, timetable);
	}
	
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // timetable �ð��� ������ �����Ͽ� pq�� ����
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<timetable.length; i++) {
        	pq.add(convertMM(timetable[i]));
        }
        
        // 09:00 ù ���� - ��Ʋ ����n, ��Ʋ ���� ���� t, �ѹ��� Ż �� �ִ� �� m
        int startTime = 540;
		int temp_m = 0;
		PriorityQueue<Integer> pq_board_time = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
        	startTime = 540 + i * t;
        	temp_m = m;
			while (!pq.isEmpty()) {
				int board_time = pq.peek();

				if (board_time <= startTime && temp_m > 0) {
					temp_m--;
					pq_board_time.add(pq.poll());
				} else
					break;
			}
        }
        
        if(temp_m == 0) { // ������ �����ð��� �� ���� => ���� �ʰ� ź ������� 1�� ����
        	// System.out.println("temp_m == 0");
        	answer = covertHH(pq_board_time.peek()-1);
        }else { // �ڸ��� ���´ٸ� �׳� ���� ��߽ð��� ž���ϸ� ��
        	// System.out.println("else " + startTime);
        	answer = covertHH(startTime);
        }
        System.out.println("���� " + answer);
        return answer;
    }
    
    public static String covertHH(int time) {
    	String hh = String.format("%02d", time/60);
    	String mm = String.format("%02d", time%60);
    	return hh+":"+mm;
    }

    
    public static int convertMM(String str_time) {
    	
    	String strSplit[] = str_time.split(":");
    	// System.out.println("convertMM " + (Integer.parseInt(strSplit[0]) * 60 + Integer.parseInt(strSplit[1])));
    	return Integer.parseInt(strSplit[0]) * 60 + Integer.parseInt(strSplit[1]);
    }

}

