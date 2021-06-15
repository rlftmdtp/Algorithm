package Programmers.level2;

import java.util.*;

public class MenuRenewal {
	public static HashMap<String, Integer> hm;
	public static boolean visited[];
	public static int MAX;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orders[] = {"XYZ", "XWY", "WXA"};
		int course[] = {2,3,4};
		System.out.println(solution(orders, course));
	}
	
    public static String[] solution(String[] orders, int[] course) {
    	
        PriorityQueue<String> pq = new PriorityQueue<String>(); // 정답의 세트 메뉴명 오름차순 정렬을 위해 pq 사용
        for(int i=0; i<course.length; i++) {
        	int setSize = course[i];
    		MAX = 0;
    		hm = new HashMap<String, Integer>();
        	for(String order : orders) {
        		visited = new boolean[order.length()];
        		char orderArray[] = order.toCharArray();
        		Arrays.sort(orderArray); // 주문 메뉴 순서가 랜덤이므로 오름차순 정렬 시킴
        		makeSetMenu(orderArray, setSize, 0);
        	}
        	
        	for(String key : hm.keySet()) {
        		if(hm.get(key) > 1 && hm.get(key) == MAX) pq.add(key);
        	}
        }
        
        String answer[] = new String[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
        	answer[i++] = pq.poll();
        }
        return answer;
    }

	private static void makeSetMenu(char orderArray[], int setSize, int depth) {
		// TODO Auto-generated method stub
		
		// 조합을 이용
		if(setSize == 0) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<orderArray.length; i++) {
				if(visited[i] == true) sb.append(orderArray[i]);
			}
			hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) +1);
			MAX = Math.max(MAX, hm.get(sb.toString()));
		} else if(orderArray.length == depth) return;
		else {
			visited[depth] = true;
			makeSetMenu(orderArray, setSize-1, depth+1); // 메뉴 하나를 선택 했을 때
			visited[depth] = false;
			makeSetMenu(orderArray, setSize, depth+1); // 메뉴 하나를 선택 했을 때
		}
	}

}
