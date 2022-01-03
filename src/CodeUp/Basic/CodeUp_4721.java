package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4721 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Candidate> q = new LinkedList<>();
		for(int i=0; i<3; i++) {
			q.add(new Candidate(i+1, 0, new int[3]));
		}
		
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			for(int j=0; j<3; j++) {
				Candidate candidate = q.poll();
				// System.out.println("후보 번호 확인 " + candidate.number);
				candidate.sum += Integer.parseInt(strSplit[j]);
				candidate.sum_count[Integer.parseInt(strSplit[j])-1]++;
				q.add(candidate);
			}
		}
		
		Candidate candidate = q.poll();
		while(!q.isEmpty()) {
			Candidate another_candidate = q.poll();
			
			if(candidate.sum == another_candidate.sum) {
				if(candidate.sum_count[2] == another_candidate.sum_count[2]) {
					if(candidate.sum_count[1] == another_candidate.sum_count[1]) {
						candidate.number = 0;
					}else {
						candidate = candidate.sum_count[1] > another_candidate.sum_count[1] ? candidate : another_candidate;
					}
				}else {
					candidate = candidate.sum_count[2] > another_candidate.sum_count[2] ? candidate : another_candidate;
				}
			}else {
				candidate = candidate.sum > another_candidate.sum ? candidate : another_candidate;
			}
				
		}
		
		System.out.println(candidate.number + " " + candidate.sum);
	}

}

class Candidate{
	int number;
	int sum;
	int sum_count[];
	
	public Candidate(int number, int sum, int sum_count[]) {
		this.number = number;
		this.sum = sum;
		this.sum_count = sum_count;
	}
}