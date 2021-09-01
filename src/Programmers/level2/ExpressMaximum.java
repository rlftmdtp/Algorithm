package Programmers.level2;

import java.util.*;
import java.util.regex.*;

public class ExpressMaximum {
	public static String operator[];
	public static String number[];
	public static List<String> resultOperator = new ArrayList<>();
	public static boolean visitied[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "100-200*300-500+20";
		solution(expression);
	}

    public static long solution(String expression) {
        long answer = 0;
        
        operator = expression.split("[0-9]+"); // 연산자 추출
        number = expression.split("[^0-9]+");	// 숫자 추출
        
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<operator.length; i++) {
        	hs.add(operator[i]);
        }
        
        // 연산자 생성
        List<String> operatorList = new ArrayList<>();
        Iterator it = hs.iterator();
        while(it.hasNext()) {
        	operatorList.add((String)it.next());
        }

        
        // 연산자 순열 생성
        visitied = new boolean[operatorList.size()];
		
		  perm(operatorList, 0);
	
        

       
        // 연산자 조합 생성
        //perm();
        // 가장 큰 금액을 계산해라
        return -1;
    }

	private static void perm(List<String> operatorList, int depth) {
		// TODO Auto-generated method stub
		if(depth == operatorList.size()) {
	        Queue<String> q = new LinkedList<>();
	        q.add(number[0]); // operator[0] 은 빈공백이므로 생략한다
	        for(int i=1; i<number.length; i++) {
	        	q.add(operator[i]);
	        	q.add(number[i]);
	        } // 큐 생성
	        
			// operatorList에 존재하는 우선순위에 따라 값 계산을 한다
	        for(int i=0; i<resultOperator.size(); i++) {
	        	String oper = resultOperator.get(i);
	        	for(String s : q) {
	        		System.out.println("z");
	        		String before = s;
	        		if(!s.equals(before)) q.add(s);
	        	}
	        }
		}else {
			for(int i=0; i<operatorList.size(); i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					resultOperator.add(operatorList.get(i));
					perm(operatorList, depth+1);
					
					visitied[i] = false;
					resultOperator.remove(resultOperator.size()-1);
				}
			}
		}
	}


}
