package Programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClapClap { // 수박수박수박?

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
	
    public static String solution(int n) {
        String answer = "";
        
        // 홀수 수, 짝수 박
        for(int i=1; i<=n; i++) {
        	if(i%2 == 0) answer += "박";
        	else answer += "수";
        }
        return answer;
    }

}
