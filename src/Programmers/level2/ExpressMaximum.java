package Programmers.level2;

import java.util.*;

public class ExpressMaximum {
	
	public static List<String> priorityOper = new ArrayList<>();
	public static String makeOper = "";
	public static boolean visited[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "100-200*300-500+20";
		solution(expression);
	}

    public static long solution(String expression) {
        long answer = 0;
        
        // 연산자 추출
        HashSet<Character> hs = new HashSet<>();
        String operatorStr = expression.replaceAll("[0-9]", ""); // 숫자 제거
        for(int i=0; i<operatorStr.length(); i++) {
        	hs.add(operatorStr.charAt(i));
        }
        
        // 연산자로 만들수 있는 순열 생성 nPr
        List<Character> list = new ArrayList<>();
        Iterator it =  hs.iterator();
        while(it.hasNext()) {
        	list.add((Character) it.next());
        }
        visited = new boolean[list.size()];
        operPerm(list,0);
        
//        for(Character operator : list){
//        	System.out.println(operator);
//        }
        
        //operPerm(hm);
        
        

        return answer;
    }

	private static void operPerm(List<Character> list, int depth) {
		// TODO Auto-generated method stub
		
		if(depth == list.size()) {
			System.out.println(makeOper);
			priorityOper.add(makeOper);
			makeOper = "";
		}else {
			for(int i=0; i<list.size(); i++) {
				if(visited[i] == false) {
					visited[i] = true;
					makeOper += list.get(i);
					operPerm(list, depth+1);
					visited[i] = false;
				}
			}
		}
		
	}
}
