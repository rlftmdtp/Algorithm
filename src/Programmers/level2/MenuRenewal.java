package Programmers.level2;

import java.util.*;

public class MenuRenewal {
	public static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public static StringBuilder setMenu = new StringBuilder();
	public static boolean visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orders[] = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int course[] = {2,3,5};
		System.out.println(solution(orders, course));
	}
	
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(String order : orders) {
        	for(int setSize : course) {
        		makeSetMenu(order, setSize, 0);
        	}
        }
        
        List<String> result = new ArrayList<String>();
        for(String key : hm.keySet()) {
        	if(hm.get(key) > 1) {
        		result.add(key);
        		//System.out.println("key " + key + " value " + hm.get(key) );
        	}
        }
        
        return answer;
    }

	private static void makeSetMenu(String order, int setSize, int count) {
		// TODO Auto-generated method stub
		
		// 순열과 조합의 차이 ..?
		if(count == setSize) {
			System.out.println("setMenu.toString() " + setMenu.toString());
			hm.put(setMenu.toString(), hm.getOrDefault(setMenu.toString(), 0) +1);
		}
		else {
			for(int i=count; i<order.length(); i++) {
				setMenu.append(order.charAt(i));
				makeSetMenu(order,setSize, count+1);
				setMenu.deleteCharAt(setMenu.length()-1);
			}
		}
	
	}

}
