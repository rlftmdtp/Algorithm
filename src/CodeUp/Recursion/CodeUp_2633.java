package CodeUp.Recursion;

import java.io.*;

public class CodeUp_2633 { // Lower Bound
	public static int N;
	public static int K;
	public static int list[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split("\\s");
		
		N = Integer.parseInt(strSplit[0]);
		K = Integer.parseInt(strSplit[1]);
		
		strSplit = br.readLine().split("\\s");
		list = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = Integer.parseInt(strSplit[i-1]);
		}
		
		System.out.println(search(1));
	}
	
	private static int search(int i) {
		// TODO Auto-generated method stub
		if(i > N) return N+1;
		else if(list[i] == K) return i;
		else if(list[i-1] < K && K < list[i]) return i;
 		else {
			return search(i+1);
		}
	}
	
	

}
