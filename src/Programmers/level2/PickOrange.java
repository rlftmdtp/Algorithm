package Programmers.level2;

import java.util.*;

public class PickOrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int k, int[] tangerine) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<tangerine.length; i++) {
			int key = tangerine[i];
			if(hm.containsKey(key) == false) {
				hm.put(key, 1);
			}else hm.put(key, hm.get(key) + 1);
		}
		
		// 내림차순 정렬
		List<Integer> list = new ArrayList<>(hm.keySet());
		list.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));
		
		// 최소값 찾기 
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			int n = hm.get(list.get(i));
			
			if(k>=n) {
				k = k-n;
				result++;
			}else break;
		}
		
		return result == 0 ? result+1 : result;
	}

}
