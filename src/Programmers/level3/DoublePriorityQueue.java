package Programmers.level3;

import java.util.*;

public class DoublePriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String operations[] = {"I 7","I 5","I -5","D -1"};
		solution(operations);
	}
	
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // ���� ���� ť
        List<Integer> q = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++) {
        	String splitStr[] = operations[i].split(" ");
        	
        	switch (splitStr[0]) {
				case "I": {
					q.add(Integer.parseInt(splitStr[1]));
					Collections.sort(q);
					break;
				}
				case "D": {
					if(q.size() == 0) break; // ��ť ������ ���� ���� ����
					else {
						if(Integer.parseInt(splitStr[1]) == 1) { // �ִ� ����
							q.remove(q.size()-1);
						}else { // �ּҰ� ����
							q.remove(0);
						}
						break;
					}
				}
        	}
        }
        
        if(q.size() == 0) {
        	answer[0] = 0;
            answer[1] = 0;
        }else {
        	answer[0] = q.get(q.size()-1);
            answer[1] = q.get(0);
        }
        
        return answer;
    	}
}
