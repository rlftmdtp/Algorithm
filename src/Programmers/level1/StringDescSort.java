package Programmers.level1;

import java.io.*;
import java.util.*;

public class StringDescSort { // 문자열 내림차순 정렬

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(solution(s));
	}
	
    public static String solution(String s) {
    	String asnwer = "";
        Character chList[] = new Character[s.length()];
        for(int i=0; i<s.length(); i++) {
        	chList[i] = s.charAt(i);
        }
        
        Arrays.sort(chList, Collections.reverseOrder());
        
        for(int i=0; i<chList.length; i++) {
        	asnwer += chList[i];
        }
        return asnwer;
    }
}
