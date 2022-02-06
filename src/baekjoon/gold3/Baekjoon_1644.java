package baekjoon.gold3;

import java.io.*;
import java.util.*;

public class Baekjoon_1644 {

	   private static ArrayList<Integer> primes;
	    public static boolean[] primeNumcheck;
	    private static int n;
	    private static int cnt;
	    public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        // 소수 구하기
	 
	        primeNumcheck = new boolean[n+1];
	        primes = new ArrayList<Integer>();
	 
	        primeNumcheck[0]=primeNumcheck[1]=true;
	        for(int i =2; i*i<=n; i++){
	            if(!primeNumcheck[i]){
	                for (int j = i*i; j <=n ; j += i) {
	                    primeNumcheck[j]=true;
	                }
	            }
	        }
	        for (int i = 1; i <=n ; i++) {
	            if(!primeNumcheck[i]){
	            	// System.out.println("소수 리스트 수 " + i);
	                primes.add(i);
	            }
	        }
	        
	        int start = 0;
	        int end = 0;
	        int total = 0;
	        int count = 0;
	        while(true){	        	
	        	if(total >= n) {
	        		total -= primes.get(start++);
	        	}else if(end == primes.size()) break;
	        	else total += primes.get(end++);
	        	
	        	if(total == n) count++;
	        }
	        System.out.println(count);
	}

	

}
