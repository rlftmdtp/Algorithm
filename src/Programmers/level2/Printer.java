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
        	int size = q.size();
        	Print topP = q.peek();
        	for(int i=0; i<size; i++) {
        		Print p = q.poll();
        		if(p.priority <= topP.priority) q.add(p);
        		else {
        			if(p.index == location) return count;
        			count++;
        			break;
        		}
        	}
        	// 한바퀴 전수 검사 더 큰 중요도가 없을 시
        	Print p = q.peek();
        	if(p.index == location) return count;
        	count ++;
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
