package Programmers.level1;
import java.io.*;

public class Collatz { // Äİ¶óÃ÷ ÃßÃø

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(n));
	}

	private static int solution(int num1) {
		// TODO Auto-generated method stub
		long num = num1;
		
		int i=0;
		while(num != 1) {
			num = (num%2 == 0) ? num/2 : num*3+1;
			i++;
			
			if(i>500) return -1;
		}
		return i;
	}

}
