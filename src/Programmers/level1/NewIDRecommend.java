package Programmers.level1;

public class NewIDRecommend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "z-+.^.";
		solution(new_id);
	}
	
    public static String solution(String new_id) {
    	   String answer = "";

//         1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�. ~ 4�ܰ�
         answer = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("[.]+", ".").replaceAll("^[.]|[.]$", "");

//         5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
         if(answer.equals("")) answer = "a";
         System.out.println(answer);

//         6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
//         ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
         if(answer.length() >= 16) {
             answer = answer.substring(0, 15);
             answer = answer.replaceAll("[.]$", "");
         }

//         7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
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
