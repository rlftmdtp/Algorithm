package Programmers.level3;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacde";
		solution(s);
	}
	
    public static int solution(String s)
    {
        int answer = 0;
        
        int start = s.length()%2 == 0 ? s.length()/2 - 1 : s.length()/2;
        System.out.println(start + " start");
        
        boolean flag = true;
        while(flag) {
        	String before = s.substring(0,start);
        	String after = s.substring(start+1, start+start+1);
        	
        	// 하나를 스택에 넣고 뺴면서 비교한다
        	System.out.println("before " + before + " start " + after);
        	flag = false;
        	// 앞뒤 똑같은지 검사
        	
        }

        return answer;
    }

}
