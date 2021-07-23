package Programmers.level2;

import java.util.*;

public class Compress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "KAKAO";
		solution(msg);
	}
	
    public static int[] solution(String msg) {
        int[] answer = {};
        
        // ���� �ʱ�ȭ
        HashMap<String, Integer> hm = new HashMap<>();
        for(char i='A'; i<='Z'; i++) {
        	System.out.println(i + " " + ( i-'A'+1));
        	hm.put(i+"", i-'A'+1);
        }
        
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<msg.length(); i++) {
        	q.add(msg.charAt(i)+"");
        }
        
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
        	String start = q.poll();
        	
        	// ���� �� ���ڿ� w ã��
        	while(hm.containsKey(start+q.peek())) {
        		start = start + q.poll();
        	}
        	
        	// w�� �ش��ϴ� ���� ��ȣ ���
        	list.add(hm.get(start));
        	
        	if(!q.isEmpty()) {
        		hm.put(start + q.peek(), hm.size()+1);
        	}
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }

}
