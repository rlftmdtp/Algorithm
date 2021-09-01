package baekjoon.silver3;

import java.io.*;
import java.util.*;


public class StackSequence {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		List<String> result = new ArrayList<>();
		int top = 0;
		for(int i=0; i<array.length; i++) {
			int N = array[i];
			
			// �ڱ� �ڽź��� ���ų� ������ ������
			// �ڱ� �ڽź��� ũ�� �ִ´�
			if(st.isEmpty()) {
				for(int j=top+1; j<=N; j++){
					st.push(j);
					result.add("+");
				}
				top = st.pop(); // ���� �ڱ��ڽ��� ������
				result.add("-");
			}else if(N < top){
				
				if(st.peek() != N) // NO�ΰ��
				{
					System.out.println("NO");
					return;
				}
				else {
					st.pop();
					result.add("-");
				}
				
			}else { // N>TOP
				for(int j=top+1; j<=N; j++){
					st.push(j);
					result.add("+");
				}
				top = st.pop(); // ���� �ڱ��ڽ��� ������
				result.add("-");
			}
		}

		// �������
		for(int i=0; i<result.size(); i++) {
			if(i == result.size()-1) System.out.print(result.get(i));
			else System.out.println(result.get(i));
		}
	}

}
