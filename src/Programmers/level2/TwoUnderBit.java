package Programmers.level2;

public class TwoUnderBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long numbers[] = {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100};
		solution(numbers);
	}
	
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	long number = numbers[i];
        	Long startNumber = number;
        	String strNumber = Long.toBinaryString(number);
        	
        	// ���� �ϳ��� �÷����鼭 �ڸ����� ���Ѵ� 
        	boolean flag = true;
        	while(flag) {
        		startNumber++;
        		String nextStrNumber = Long.toBinaryString(startNumber);
        		
        		// �ڸ��� ���߱�
        		if(strNumber.length() > nextStrNumber.length()) {
        			nextStrNumber = makeEqual(strNumber, nextStrNumber);
        		}else {
        			strNumber = makeEqual(nextStrNumber, strNumber);
        		}
        		System.out.println(strNumber + "   " + nextStrNumber);
        		int compareCount = 0;
        		for(int j=0; j<strNumber.length(); j++) {
        			if(strNumber.charAt(j) != nextStrNumber.charAt(j)) compareCount++;
        		}
        		
        		if(compareCount <= 2) flag = false;
        	}
        	answer[i] = startNumber;
        	//System.out.println(startNumber);
        }
        
        return answer;
    }
    
    public static String makeEqual(String number, String makeNumber) {
    	int count = number.length() - makeNumber.length();
    	   	
    	// ���ڸ� ��ŭ�� �ڸ����� ä���ش�
    		for(int i=0; i<count; i++) {
    			makeNumber = "0" + makeNumber;
    		}
    		return makeNumber;
    }

}
