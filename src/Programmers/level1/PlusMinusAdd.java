package Programmers.level1;

public class PlusMinusAdd {
	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            int absolute = absolutes[i];
            
            if(signs[i]){
                answer = answer + absolute;
            }else{
                answer = answer - absolute;
            }
        }
        
        return answer;
    }
}
