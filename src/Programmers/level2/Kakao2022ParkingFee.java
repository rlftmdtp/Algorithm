package Programmers.level2;

import java.util.*;

public class Kakao2022ParkingFee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		solution(fees, records);
	}
	
    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Stack<String>> hm = new HashMap<>();
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for(int i=0; i<records.length; i++) {
        	String strSplit[] = records[i].split(" ");
        	
        	String car_time = strSplit[0];
        	String car_number = strSplit[1];
        	// 초기화
        	if(!hm.containsKey(car_number)) {
        		hm.put(car_number, new Stack<>());
        	}
        	
        	Stack<String> st = hm.get(car_number);
        	st.push(car_time);
        }
        
        // 차 별 요금 계산
        for(String car_number : hm.keySet()) {
        	Stack<String> st = hm.get(car_number);
        	int total_time = 0; // 차 별 총 누적 시간을 구한다
        	
        	while(!st.isEmpty()) {
            	// 맨 처음 st 사이즈가 홀수이면 마지막 출차 기록이 없는 것 23:59
            	if(st.size() % 2 == 1) {
            		total_time += calTime("23:59", st.pop());
            	}else {
            		String end = st.pop();
            		String start = st.pop();
            		total_time += calTime(end, start);
            	}
        	}
        	
        	// 금액 꼐산 후 우선순위 큐 입력
        	pq.add(new Car(Integer.parseInt(car_number), calFee(fees, total_time)));
        	
        	// System.out.println(car_number + " 의 전체시간 " + total_time);
        }
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()) {
        	System.out.println(pq.peek().car_number + " " + pq.peek().money);
        	answer[index++] = pq.poll().money;
        }
        
        return answer;
    }
    
    public static int calFee(int fees[], int total_time) {
    	total_time -= fees[0];
    	
    	// 기본 주차금액보다 작으면 기본금맥만 부과
    	if(total_time < 0) return fees[1];
    	
    	// 단위 시간 단위 요금
    	int result = 0;
    	// 초과시간이 단위시간으로 나누어 떨어지지 않을 경우 - 올림 처리   
    	if(total_time % fees[2] != 0) result =  (total_time / fees[2]) * fees[3] + fees[1] + fees[3];
    	else result = (total_time / fees[2]) * fees[3] + fees[1];
    	System.out.println("누적 금액 " + result);
    	return result;
    }
    
    public static int calTime(String end, String start) {
    	
    	// 시 분 계산
    	String strSplit[] = end.split(":");
    	int end_hour = Integer.parseInt(strSplit[0]);
    	int end_min = Integer.parseInt(strSplit[1]);
    	strSplit = start.split(":");
    	int start_hour = Integer.parseInt(strSplit[0]);
    	int start_min = Integer.parseInt(strSplit[1]);
    	
    	int end_total_time = end_hour*60 + end_min;
    	int start_total_time = start_hour*60 + start_min;
    	
    	// System.out.println("calTime " + (end_total_time - start_total_time));
    	return (end_total_time - start_total_time);
    }

}

class Car implements Comparable<Car>{
	int car_number;
	int money;
	
	public Car(int car_number, int money) {
		this.car_number = car_number;
		this.money = money;
	}
	
	public int compareTo(Car c) {
		// 차량번호 오름차순
		return this.car_number - c.car_number;
	}
}

