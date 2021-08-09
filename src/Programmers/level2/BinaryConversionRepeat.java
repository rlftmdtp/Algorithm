package Programmers.level2;

public class BinaryConversionRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "110010101001";
		solution(s);
	}
	
    public static int[] solution(String s) {
    	int result[] = new int[2];
    	
    	int count = 0;
    	int deleteZero = 0;
    	while(!s.equals("1")) {
    		String tempS = s.replaceAll("0", "");
    		deleteZero += s.length() - tempS.length();
    		s = Integer.toBinaryString(tempS.length());
    		count++;
    	}
    	
    	result[0] = count;
    	result[1] = deleteZero;
    	System.out.println(count + " " + deleteZero);
    	return result;
    	
		/*
		 * int[] answer = new int[2];
		 * 
		 * // s가 1일 경우
		 * 
		 * int conversion = 0; int totalZeroCount = 0; while(!s.equals("1")) { int
		 * zeroCount = 0;
		 * 
		 * for(int i=0; i<s.length(); i++) { if(s.charAt(i) == '0') zeroCount++; }
		 * conversion++; totalZeroCount += zeroCount; int zeroDeleteLength = s.length()
		 * - zeroCount; s = Integer.toBinaryString(zeroDeleteLength); }
		 * 
		 * answer[0] = conversion; answer[1] = totalZeroCount;
		 * System.out.println(answer[0] + ", " + answer[1]); return answer;
		 */
    }

}
