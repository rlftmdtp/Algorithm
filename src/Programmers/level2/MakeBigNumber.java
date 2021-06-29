package Programmers.level2;

public class MakeBigNumber {
	public static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1231234";
		int k = 3;
		System.out.println(solution(number, k));
	}
	
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        k = number.length() - k;
        int index = -1;
        
        for(; k>0; k--) {
        	char MAX = '0';
        	for(int j=index+1; j<=number.length()-k; j++) {
        		if(number.charAt(j) > MAX) {
        			MAX = number.charAt(j);
        			index = j;
        		}
        	}
        	sb.append(MAX);
        }
        
        return sb.toString();
    }



}
