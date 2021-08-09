package Programmers.level2;

public class JadenCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for(int i=0; i<s.length(); i++) {
        	if(count == 0) {
                if(s.charAt(i) == ' '){
                    count = 0;
        		    sb.append(" ");
                }else{
                    sb.append((s.charAt(i)+"").toUpperCase());
        		    count++;
                }
        	}
        	else if(s.charAt(i) == ' ') {
        		count = 0;
        		sb.append(" ");
        	}else {
        		sb.append((s.charAt(i)+"").toLowerCase());
        		count++;
        	}
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
