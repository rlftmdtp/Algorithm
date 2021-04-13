package Programmers.level1;

import java.util.*;

public class NotFinishPlayer { // 완주 하지 못한 선수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
	}
	
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for(i=0; i<completion.length; i++) {
        	if(!completion[i].equals(participant[i])) return participant[i];
        }
        
        return participant[i];
    }

}
