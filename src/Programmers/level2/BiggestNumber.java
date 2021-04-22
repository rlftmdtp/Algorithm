package Programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {6, 10, 2};

		System.out.println(solution(numbers));
	}
	
    public static String solution(int[] numbers) {
    	StringBuilder sb = new StringBuilder();
    	
    	String str_numbers[] = new String[numbers.length];
    	for(int i=0; i<numbers.length; i++) {
    		str_numbers[i] = String.valueOf(numbers[i]);
    	}
    	
    	Arrays.sort(str_numbers, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});
    	
    	for(String number : str_numbers) {
    		sb.append(number);
    	}
    	
        return sb.charAt(0) == '0' ? "0" : sb.toString(); // 맨 앞자리가 0인것은 모든 배열이 0인것을 의미
    }
}
