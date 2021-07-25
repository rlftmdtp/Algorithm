package Programmers.level1;

public class StringNumberAlphapet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int solution(String s) {
        
        String alphapet[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<alphapet.length; i++){
            s = s.replaceAll(alphapet[i], i+"");
        }

        return Integer.parseInt(s);
    }

}
