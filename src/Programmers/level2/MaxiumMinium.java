package Programmers.level2;

public class MaxiumMinium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "-1 -1";
		System.out.println(solution(s));
	}
	
    public static String solution(String s) {
        String answer = "";
        
        String splitStr[] = s.split(" ");
        
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for(int i=0; i<splitStr.length; i++) {
        	if(MAX < Integer.parseInt(splitStr[i])) MAX = Integer.parseInt(splitStr[i]);
        	if(MIN > Integer.parseInt(splitStr[i])) MIN = Integer.parseInt(splitStr[i]);
        }
        
        return answer = MIN + " " + MAX;
    }

}
