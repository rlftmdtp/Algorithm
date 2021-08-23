package Programmers.level2;

import java.util.*;

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcdcdababcdcd";
		solution(s);
	}
	
    public static int solution(String s) {
    	int answer = s.length();
        
        // 앞에서 부터 정해진 길이 만큼 자르기
        for(int i=1; i<s.length(); i++) {
            Queue<String> q = new LinkedList<>();
        	int last = 0;
        	for(int j=0; j*i+i<=s.length(); j++) {
        		//System.out.println(s.substring(j*i, j*i+i));
        		q.add(s.substring(j*i, j*i+i));
        		last = j*i+i;
        	}
        	//System.out.println("last " + s.substring(last, s.length()));
        	q.add(s.substring(last, s.length()));
        	
        	StringBuilder sb = new StringBuilder();
        	while(!q.isEmpty()) {
        		String before = q.poll();
        		
        		int count = 1;
        		while(true) {
        			if(before.equals(q.peek())) {
        				count++;
        				q.poll();
        			}else break;
        		}
        		
        		if(count == 1) sb.append(before);
        		else sb.append(count + before);
        	}
        	//System.out.println(sb.toString());
        	if(answer > sb.toString().length()) answer = sb.toString().length();
        }
        //System.out.println(answer);
        return answer;
    }

}
