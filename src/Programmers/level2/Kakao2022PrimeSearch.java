package Programmers.level2;

import java.util.*;
import java.util.regex.*;

public class Kakao2022PrimeSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 437674;
		int k = 3;
		
//		int n = 997244;
//		int k = 3;
		solution(n,k);

	}

    public static int solution(int n, int k) {
        // 1. 진수 변환
        String convert_k = convert(n,k);
        // System.out.println(convert_k);
        // 2. 각 상황별 소수 찾기
        return primeCheck(convert_k); // 조건에 성립하는 소수 갯수 반환
    }
    
    public static int primeCheck(String number) {
    	int result = 0;
    	// 소수 양쪽 0
    	Pattern p = Pattern.compile("[^0]+");
    	Matcher m = p.matcher(number);
    	
    	// int 범위를 넘는 경우 ...?
    	while(m.find()) {
    		String find_prime = m.group();
    		// System.out.println("찾은 소수 " + find_prime);
    		if(valid(find_prime)) result++;
    	}
    	System.out.println("정답 " + result);
    	return result;
    }
    
    public static boolean valid(String find_prime) {
    	// int형을 넘을 수 있음에 주의를 해야한다 ex) int n = 997244  int k = 3
    	long a = Long.parseLong(find_prime);
    	// System.out.println("int형 확인 " + a);
    	if(a == 1) return false;
    	
    	for(int i=2; i<a; i++) {
    		if(a%i == 0) return false;
    	}
    	return true;
    }
    
    public static String convert(int n, int k) {
    	// k진수
    	StringBuilder sb = new StringBuilder();
    	while(n!=0) {
    		sb.append(n%k);
    		n = n/k;
    	}
    	// 거꾸로 바꾸기

    	return sb.reverse().toString();
    }
}
