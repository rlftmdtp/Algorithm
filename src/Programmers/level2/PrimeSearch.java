package Programmers.level2;

import java.util.HashSet;

public class PrimeSearch {
	public static HashSet<String> hs = new HashSet<String>(); // �ߺ����� ���� ���ܸ� ���� set ���
	public static boolean visited[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	
	
    public static int solution(String numbers) {
        char charNumbers[] = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        
        // numbers�� ���� ������ �̿��Ͽ� ���������� ����
        for(int i=0; i<numbers.length(); i++) {
        	recursion(i+1, 0, charNumbers);
        }
        return hs.size();
    }


	private static void recursion(int n, int r, char[] charNumbers) {
		// TODO Auto-generated method stub
		if(n == r) {
			if(isPrime(sb)) {
				hs.add(sb.toString());
			}
		}else {
			for(int i=0; i<charNumbers.length; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					sb.append(charNumbers[i]);
					recursion(n, r+1, charNumbers);
					sb.deleteCharAt(sb.length()-1);
					visited[i] = false;
				}
			}
		}
	}
	
	private static boolean isPrime(StringBuilder sb) {
		// TODO Auto-generated method stub
		// ���ڸ� 0 üũ
		System.out.println("sb " + sb.toString());
		System.out.println("int "+ Integer.parseInt(sb.toString()));
		if(sb.charAt(0) == '0' || (sb.length() == 1 && sb.charAt(0) == '1')) return false;
		else {
			int check = Integer.parseInt(sb.toString());
			// �Ҽ� �Ǻ�
			for(int i=2; i<check; i++) {
				if(check%i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
}
