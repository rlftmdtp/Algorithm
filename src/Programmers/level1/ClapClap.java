package Programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClapClap { // ���ڼ��ڼ���?

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
	
    public static String solution(int n) {
        String answer = "";
        
        // Ȧ�� ��, ¦�� ��
        for(int i=1; i<=n; i++) {
        	if(i%2 == 0) answer += "��";
        	else answer += "��";
        }
        return answer;
    }

}
