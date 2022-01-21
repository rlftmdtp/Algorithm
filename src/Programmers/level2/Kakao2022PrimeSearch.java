package Programmers.level2;

import java.util.*;
import java.util.regex.*;

public class Kakao2022PrimeSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 437674;
		int k = 3;
		solution(n,k);

	}

    public static int solution(int n, int k) {
        int answer = -1;
        
        // 1. 진수 변환
        String convert_k = convert(n,k);
        System.out.println(convert_k);
        // 2. 각 상황별 소수 찾기
        primeCheck(convert_k); // 조건에 성립하는 소수 갯수 반환
        return answer;
    }
    
    public static int primeCheck(String number) {
//    	0P0처럼 소수 양쪽에 0이 있는 경우
//    	P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
//    	0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
//    	P처럼 소수 양쪽에 아무것도 없는 경우
    	
    	// 소수 양쪽 0
    	Pattern p = Pattern.compile("0[0-9]+0");
    	Matcher m = p.matcher(number);
    	
    	while(m.find()) {
    		System.out.println(m.group());
    	}

    	return -1;
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
