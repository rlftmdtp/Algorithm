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
        // 1. ���� ��ȯ
        String convert_k = convert(n,k);
        // System.out.println(convert_k);
        // 2. �� ��Ȳ�� �Ҽ� ã��
        return primeCheck(convert_k); // ���ǿ� �����ϴ� �Ҽ� ���� ��ȯ
    }
    
    public static int primeCheck(String number) {
    	int result = 0;
    	// �Ҽ� ���� 0
    	Pattern p = Pattern.compile("[^0]+");
    	Matcher m = p.matcher(number);
    	
    	// int ������ �Ѵ� ��� ...?
    	while(m.find()) {
    		String find_prime = m.group();
    		// System.out.println("ã�� �Ҽ� " + find_prime);
    		if(valid(find_prime)) result++;
    	}
    	System.out.println("���� " + result);
    	return result;
    }
    
    public static boolean valid(String find_prime) {
    	// int���� ���� �� ������ ���Ǹ� �ؾ��Ѵ� ex) int n = 997244  int k = 3
    	long a = Long.parseLong(find_prime);
    	// System.out.println("int�� Ȯ�� " + a);
    	if(a == 1) return false;
    	
    	for(int i=2; i<a; i++) {
    		if(a%i == 0) return false;
    	}
    	return true;
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
