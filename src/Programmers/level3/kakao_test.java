package Programmers.level3;

import java.util.*;

public class kakao_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fees[] = {180, 5000, 10, 600};
		String records[] = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
		
		List<String> list = new ArrayList<>();
		list.add("0010");
		list.add("0100");
		list.add("0020");
		
		list.sort(Collections.reverseOrder());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		solution(fees, records);
	}
	
	public static int[] solution(int[] fee, String[] records) {
		
		TreeMap<String, Car> hm = new TreeMap<>();
		//  ���ڿ� ����
		for(int i=0; i<records.length; i++) {
			String strSplit[] = records[i].split(" ");
			
			if(!hm.containsKey(strSplit[1])) {
				hm.put(strSplit[1], new Car());
			}
			
			Car car = hm.get(strSplit[1]);
			if(strSplit[2].equals("IN")) {
				car.st.push(strSplit[0]);
			}else { // OUT �̸� ���
				// �ð� ��� �� ��ȯ
				car.totalTime += calTime(strSplit[0], car.st.pop());
			}
		}

		int result[] = new int[hm.size()];
		for(String key : hm.keySet()) {
			System.out.println(" �ڵ��� ��ȣ " + key);
			Car car = hm.get(key);
			
			// ���� ����Ȯ��
			if(!car.st.isEmpty()) {
				// ������ �ð� ���
				car.totalTime += calTime("23:59", car.st.pop());
			}
			System.out.println("�ڵ��� ���� �ð� " + car.totalTime);
			
			// �ݾ� ���
			calMoney();
		}
		
		
		return null;
	}

	private static int calTime(String outTime, String inTime) {
		// TODO Auto-generated method stub
		int hour;
		int min;
		
		String strSplit[] = outTime.split(":");
		String strSplit2[] = inTime.split(":");
		
		hour = Integer.parseInt(strSplit[0]) - Integer.parseInt(strSplit2[0]);
		min = Integer.parseInt(strSplit[1]) - Integer.parseInt(strSplit2[1]);
		
		return hour*60+min;
	}	

}

class Car{
	int totalTime;
	Stack<String> st = new Stack<>();
	
	
}