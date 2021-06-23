package Programmers.level2;

public class BinaryConversionRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "110010101001";
		solution(s);
	}
	
    public static int[] solution(String s) {
        int[] answer = new int[2];
        
        // s가 1일 경우
        
        int conversion = 0;
        int totalZeroCount = 0;
        while(!s.equals("1")) {
        	int zeroCount = 0;
        	
        	for(int i=0; i<s.length(); i++) {
        		if(s.charAt(i) == '0') zeroCount++;
        	}
        	conversion++;
        	totalZeroCount += zeroCount;
        	int zeroDeleteLength = s.length() - zeroCount;
        	s = Integer.toBinaryString(zeroDeleteLength);
        }
        
        answer[0] = conversion;
        answer[1] = totalZeroCount;
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }

}
