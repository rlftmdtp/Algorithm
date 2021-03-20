package Programmers.level2;

import java.util.*;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int priorities[] = {2, 1, 3, 2};
		int location = 2;
		
		System.out.println(solution(priorities, location));
	}

    public static int solution(int[] priorities, int location) {        
        // 초기화
        Queue<Print> q = new LinkedList<Print>();
        for(int i=0; i<priorities.length; i++) {
        	q.add(new Print(i,priorities[i]));
        }
        int count = 1;
        
        while(!q.isEmpty()) {
        	Print topP = q.poll();
        	boolean flag = false;
        	for(Print p : q) {
        		if(topP.priority < p.priority) flag = true;
        	}
        	
        	// 중간에 우선순위 더 높은 값이 존재 할 시 그냥 뒤로 보낸다
        	if(flag) {
        		q.add(topP);
        	}else { // 맨 앞이 우선순위가 높을 경우
        		if(topP.index == location) return count;
        		count++;
        	}
        }
        return -1;
    }
}

class Print{
	int index;
	int priority;
	
	public Print(int index, int priority) {
		super();
		this.index = index;
		this.priority = priority;
	}
}
