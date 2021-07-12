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
            System.out.println("실패율 " + going  + "/" + clear);
            System.out.println(going/clear);
            stageArray[i] = new Stage(going%clear, i+1);
        }
        Arrays.sort(stageArray, new Comparator<Stage>() {

			@Override
			public int compare(Stage o1, Stage o2) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				if(o2.failureRate > o1.failureRate) return 1;
				else if(o2.failureRate == o1.failureRate) {
					// 더 작은 스테이지
					if(o2.stage > o1.stage) return -1;
					else return 1;
				}else {
					return -1;
				}
			}
		});

        for(int i=0; i<stageArray.length; i++) {
        	System.out.println(stageArray[i].stage);
        	answer[i] = stageArray[i].stage;
        }
        return answer;
    }

}

class Stage {
	float failureRate;
	int stage;
	
	public Stage(float failureRate, int stage) {
		this.failureRate = failureRate;
		this.stage = stage;
	}

//	@Override
//	public int compareTo(Stage o) {
//		// TODO Auto-generated method stub
//		if(o.failureRate > this.failureRate) return 1;
//		else if(o.failureRate == this.failureRate) {
//			// 더 작은 스테이지
//			if(o.stage > this.stage) return -1;
//			else return 1;
//		}else {
//			return -1;
//		}
//	}

	
}
