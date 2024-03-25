package Programmers.level2;

import java.util.HashMap;

public class DidscountEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(String[] want, int[] number, String[] discount) {
		
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<want.length; i++) {
			hm.put(want[i], number[i]);
		}
		
		// 수량 완전일치
		int answer = 0;
		for(int i=0; i<discount.length; i++) {
			HashMap<String, Integer> temp = (HashMap<String, Integer>) hm.clone();
			if(discount.length-i < 10) break; // 뒷 부분 더 진행할필요 없음
			else {
				boolean result = true;
				for(int j=0; j<10; j++) {
					if(temp.containsKey(discount[i+j]) && (temp.get(discount[i+j] != 0))) {
						temp.put(null, null)
					}
				}
			}
					
		}
		
		
		return 0;
	}

}
