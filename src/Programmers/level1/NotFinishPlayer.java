package Programmers.level1;

import java.util.*;

public class NotFinishPlayer { // 완주 하지 못한 선수

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        LinkedList<String> list = new LinkedList<String>();
        for(int i=0; i<completion.length; i++) {
        	list.add(completion[i]);
        }
        
        for(int i=0; i<participant.length; i++) {
        	String player = participant[i];
        	
        	boolean check = false;
        	for(int j=0; j<list.size(); j++) {
        		if(list.get(j).equals(player)) {
        			list.remove(j);
        			check = true;
                    break;
        		}
        	}
        	
        	if(check == false) return answer = player;
        }
        
        return answer;
    }

}
