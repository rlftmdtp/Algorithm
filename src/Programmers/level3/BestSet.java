package Programmers.level3;

public class BestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int tempN = n;
        for(int i=0; i<n; i++){
            
            // 정답이 아닐 경우            
            if(s/tempN == 0){
                    int result[] = {-1};
                    return result;
            }
            
            answer[i] = s/tempN;
            tempN--;
            s = s - answer[i];
            
            
        }

        return answer;
    }

}
