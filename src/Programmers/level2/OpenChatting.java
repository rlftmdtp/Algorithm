package Programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	
    public static String[] solution(String[] record) {
        
        HashMap<String, String> hm = new HashMap<String, String>();
        for(int i=0; i<record.length; i++) {
        	String splitRecord[] = record[i].split(" ");
        	
        	// 0 1 2
        	if(!splitRecord[0].equals("Leave")) {
            	hm.put(splitRecord[1], splitRecord[2]);
        	}
        }
        
        // 정답 변환
        List<String> list = new ArrayList<String>();
        for(int i=0; i<record.length; i++) {
        	String splitRecord[] = record[i].split(" ");
        	
        	if(splitRecord[0].equals("Change")) continue;
        	
        	// 0 1 2
        	switch (splitRecord[0]) {
			case "Enter": {
				list.add(hm.get(splitRecord[1]) + "님이 들어왔습니다.");
				break;
			}
			case "Leave": {
				list.add(hm.get(splitRecord[1]) + "님이 나갔습니다.");
				break;
			}
		    }
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }

}
