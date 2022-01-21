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
        	// �ʱ�ȭ
        	if(!hm.containsKey(car_number)) {
        		hm.put(car_number, new Stack<>());
        	}
        	
        	Stack<String> st = hm.get(car_number);
        	st.push(car_time);
        }
        
        // �� �� ��� ���
        for(String car_number : hm.keySet()) {
        	Stack<String> st = hm.get(car_number);
        	int total_time = 0; // �� �� �� ���� �ð��� ���Ѵ�
        	
        	while(!st.isEmpty()) {
            	// �� ó�� st ����� Ȧ���̸� ������ ���� ����� ���� �� 23:59
            	if(st.size() % 2 == 1) {
            		total_time += calTime("23:59", st.pop());
            	}else {
            		String end = st.pop();
            		String start = st.pop();
            		total_time += calTime(end, start);
            	}
        	}
        	
        	// �ݾ� ���� �� �켱���� ť �Է�
        	pq.add(new Car(Integer.parseInt(car_number), calFee(fees, total_time)));
        	
        	// System.out.println(car_number + " �� ��ü�ð� " + total_time);
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
    	
    	// �⺻ �����ݾ׺��� ������ �⺻�ݸƸ� �ΰ�
    	if(total_time < 0) return fees[1];
    	
    	// ���� �ð� ���� ���
    	int result = 0;
    	// �ʰ��ð��� �����ð����� ������ �������� ���� ��� - �ø� ó��   
    	if(total_time % fees[2] != 0) result =  (total_time / fees[2]) * fees[3] + fees[1] + fees[3];
    	else result = (total_time / fees[2]) * fees[3] + fees[1];
    	System.out.println("���� �ݾ� " + result);
    	return result;
    }
    
    public static int calTime(String end, String start) {
    	
    	// �� �� ���
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
		// ������ȣ ��������
		return this.car_number - c.car_number;
	}
}

