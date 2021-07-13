package Programmers.level1;

import java.util.*;

public class FailureRate {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
		int N = 5;
		solution(N, stages);
	}
	
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 실패율 스테이지에 도달했으나 아직 클리어 하지 못한 플레이서 수/스테이지 도달한 수
        // 실패율이 높은 스테이지부터 내림차순으로 (실패율이 같아면 작은번호 스테이지부터)
        //N+1은 올스테이지 클리어

        Stage stageArray[] = new Stage[N];
        for(int i=0; i<N; i++){
            
            float going = 0;
            float clear = 0;
            for(int j=0; j<	stages.length; j++){
                if(i+1 == stages[j]) going++;
                if(i+1 <= stages[j]) clear++;
            }
            float failurRate = 0; // 제한사항 : 스테이지에 모두가 도달하지 못했을 경우 0/0이므로 강제0 처리
            if(!(going == 0 && clear == 0)) failurRate = going/clear;
           
            stageArray[i] = new Stage(failurRate, i+1);
        }
        
        Arrays.sort(stageArray);
        
        for(int i=0; i<stageArray.length; i++) {
        	answer[i] = stageArray[i].stage;
        }
        return answer;
    }

}

class Stage implements Comparable<Stage>{
	float failureRate;
	int stage;
	
	public Stage(float failureRate, int stage) {
		this.failureRate = failureRate;
		this.stage = stage;
	}

	@Override
	public int compareTo(Stage o) {
		// TODO Auto-generated method stub
		if(o.failureRate > this.failureRate) return 1;
		else if(o.failureRate == this.failureRate) {
			// 더 작은 스테이지
			if(o.stage > this.stage) return -1;
			else return 1;
		}else {
			return -1;
		}
	}

	
}
