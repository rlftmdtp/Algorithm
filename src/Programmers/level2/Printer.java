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
        // �ʱ�ȭ
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
        	
        	// �߰��� �켱���� �� ���� ���� ���� �� �� �׳� �ڷ� ������
        	if(flag) {
        		q.add(topP);
        	}else { // �� ���� �켱������ ���� ���
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
