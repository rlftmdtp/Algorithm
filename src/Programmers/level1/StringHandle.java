package Programmers.level1;

import java.io.*;

public class StringHandle { // ���ڿ� �ٷ�� �⺻

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		System.out.println(solution(s));
		}
	
	
	public static boolean solution(String s) {
        boolean answer = true;
        
		if(s.length() == 4 || s.length() == 6) { // ���̰� 4 Ȥ�� 6
			for(int i=0; i<s.length(); i++) {
				// ���ڰ˻�
				if(!(48 <= s.charAt(i) && s.charAt(i) <= 57)) answer = false;
			}
		}else {
			answer = false;
		}
        
        return answer;
    }
}

