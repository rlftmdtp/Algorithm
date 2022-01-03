package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4771 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char chArray[] = str.toCharArray();
		Stack<Character> st = new Stack<>();
		int result = 0;
		for(int i=0; i<chArray.length; i++) {
			char bowl = chArray[i];
			
			if(st.isEmpty()) {
				st.push(bowl);
				result += 10;
			}
			else {
				if(st.peek() == bowl) {
					// 같은 방향
					st.push(bowl);
					result += 5;
				}else {
					// 반대 방향
					st.push(bowl);
					result += 10;
				}
			}
		}
		System.out.println(result);
	}

}
