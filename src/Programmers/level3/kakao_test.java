package Programmers.level3;

import java.util.*;

public class kakao_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int fees[] = {120, 0, 60, 591};
		int fees[] = {1, 461, 1, 10};
		// String records[] = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
		String records[] = {"00:00 1234 IN"};
		
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
	
	public static int[] solution(int[] fees, String[] records) {
		
		TreeMap<String, Car> hm = new TreeMap<>();
		//  문자열 가공
		for(int i=0; i<records.length; i++) {
			String strSplit[] = records[i].split(" ");
			
			if(!hm.containsKey(strSplit[1])) {
				hm.put(strSplit[1], new Car());
			}
			
			Car car = hm.get(strSplit[1]);
			if(strSplit[2].equals("IN")) {
				car.st.push(strSplit[0]);
			}else { // OUT 이면 계산
				// 시간 계산 후 반환
				car.totalTime += calTime(strSplit[0], car.st.pop());
			}
		}

		int result[] = new int[hm.size()];
		int index = 0;
		for(String key : hm.keySet()) {
			System.out.println(" 자동차 번호 " + key);
			Car car = hm.get(key);
			
			// 출차 유무확인
			if(!car.st.isEmpty()) {
				// 나머지 시간 계산
				car.totalTime += calTime("23:59", car.st.pop());
			}
			System.out.println("자동차 최종 시간 " + car.totalTime);
			
			// 금액 계산
			result[index++] = calMoney(fees, car.totalTime);
		}
		
		return null;
	}
	
	private static int calMoney(int[] feeds, int totalTime) {
		
		int resultMoney = 0;
		int defaultTime = feeds[0];
		int defaultMoney = feeds[1];
		int perTime = feeds[2];
		int perMoney = feeds[3];

		if(defaultTime < totalTime) {
			int resultTime = totalTime - defaultTime;
			
			if(resultTime/perTime == 0) resultMoney = perMoney + defaultMoney;
			else resultMoney = resultTime/perTime * perMoney + defaultMoney;
		}else {
			resultMoney = defaultMoney;
		}
		System.out.println(resultMoney);
		return resultMoney;
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