package Programmers.level1;

import java.util.*;

public class TwoPullAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {5,0,2,7};
		solution(numbers);
	}

	private static int[] solution(int[] numbers) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<numbers.length-1; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				int addNumber = numbers[i] + numbers[j];
				if(!list.contains(addNumber)) list.add(addNumber);
			}
		}
		
		Collections.sort(list);
		int answer[] = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	

}
