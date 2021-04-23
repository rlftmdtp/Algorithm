package Programmers.level2;

import java.util.*;

public class Camo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));
	}
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1); // 맨 처음에 put할 경우 초기화가 안되어있어 null이 나오므로 Default 0로 설정
        }
        
        Set<String> set = hm.keySet();
        for(String str : set) {
        	answer *= hm.get(str) + 1; // 한 종류의 개수에서 안 입는 경우도 있으므로 하나를 더하고 동시에 일어나는 일이므로 곱한다 
        }
        
        return answer-1; // 모든 종류를 다 입지않는 한가지 경우 제외
    }

}
