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
        
        // 1. ���� ��ȯ
        String convert_k = convert(n,k);
        System.out.println(convert_k);
        // 2. �� ��Ȳ�� �Ҽ� ã��
        primeCheck(convert_k); // ���ǿ� �����ϴ� �Ҽ� ���� ��ȯ
        return answer;
    }
    
    public static int primeCheck(String number) {
//    	0P0ó�� �Ҽ� ���ʿ� 0�� �ִ� ���
//    	P0ó�� �Ҽ� �����ʿ��� 0�� �ְ� ���ʿ��� �ƹ��͵� ���� ���
//    	0Pó�� �Ҽ� ���ʿ��� 0�� �ְ� �����ʿ��� �ƹ��͵� ���� ���
//    	Pó�� �Ҽ� ���ʿ� �ƹ��͵� ���� ���
    	
    	// �Ҽ� ���� 0
    	Pattern p = Pattern.compile("0[0-9]+0");
    	Matcher m = p.matcher(number);
    	
    	while(m.find()) {
    		System.out.println(m.group());
    	}

    	return -1;
    }
    
    public static String convert(int n, int k) {
    	// k����
    	StringBuilder sb = new StringBuilder();
    	while(n!=0) {
    		sb.append(n%k);
    		n = n/k;
    	}
    	// �Ųٷ� �ٲٱ�

    	return sb.reverse().toString();
    }
}
