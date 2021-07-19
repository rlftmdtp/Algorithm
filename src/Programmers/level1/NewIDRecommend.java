package Programmers.level1;

public class NewIDRecommend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "z-+.^.";
		solution(new_id);
	}
	
    public static String solution(String new_id) {
    	   String answer = "";

//         1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다. ~ 4단계
         answer = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("[.]+", ".").replaceAll("^[.]|[.]$", "");

//         5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
         if(answer.equals("")) answer = "a";
         System.out.println(answer);

//         6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
         if(answer.length() >= 16) {
             answer = answer.substring(0, 15);
             answer = answer.replaceAll("[.]$", "");
         }

//         7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
         if(answer.length() <= 2) {
             String addStr = answer.substring(answer.length()-1);
             int count = 3 - answer.length();
             for(int i=0; i<count; i++) {
                 answer = answer + addStr;
             }
         }

         return answer;
    }

}
