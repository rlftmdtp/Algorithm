package Programmers.level2;

public class NextBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 78;
		System.out.println(solution(n));
	}
	
    public static int solution(int n) {
        int answer = n;
        
        String binarStr = Integer.toBinaryString(n);
        int nOneCount = zeroCount(binarStr);
        
        while(true) {
        	answer++;

        	String binarStr2 = Integer.toBinaryString(answer);
        	int anwerOneCount = zeroCount(binarStr2);
        	// 1의 개수가 같은지 검사
        	if(anwerOneCount == nOneCount) break;
        }
        
        return answer;
    }
    
    public static int zeroCount(String binarStr) {
    	int oneCount = 0;
        for(int i=0; i<binarStr.length(); i++) {
        	if(binarStr.charAt(i) == '1') oneCount++;
        }
        return oneCount;
    }
}
