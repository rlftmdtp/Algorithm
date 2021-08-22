package Programmers.level1;

import java.util.*;

public class Weekly2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int scores[][] = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		solution(scores);
	}
	
    public static String solution(int[][] scores) {
        String answer = "";
        
        // 자기 자신의 평가 점수가 유일한 최고점 또는 유일한 최저점 일 경우 그 점수 제외
        for(int i=0; i<scores.length; i++) {
        	int myScore = scores[i][i];
        	int total = 0;
        	int scoreArray[] = new int[scores.length];

        	for(int j=0; j<scores.length; j++) {
        		scoreArray[j] = scores[j][i];
        		total +=  scores[j][i];
        	}
        	
        	Arrays.sort(scoreArray);
        	int minus = 0;
        	if(scoreArray[scoreArray.length-1] == myScore) { // 나의 점수가 최고이거나
        		// 유일한지 확인
        		if(scoreArray[scoreArray.length-1] != scoreArray[scoreArray.length-2]) minus = scoreArray[scoreArray.length-1];
        	}else if(scoreArray[0] == myScore) { // 나의 점수가 최저일때
        		// 유일한지 확인
        		if(scoreArray[0] != scoreArray[1]) minus = scoreArray[0];
        	}
        	int size = (minus == 0) ? scores.length : scores.length-1;

        	answer += average((total-minus)/size);
        }
        System.out.println(answer);
        return answer;
    }

	private static String average(int average) {
		// TODO Auto-generated method stub
		if(average >=90) return "A";
		else if(90>average && average>=80) return "B";
		else if(80>average && average>=70) return "C";
		else if(70>average && average>=50) return "D";
		else return "F";
	}

}
