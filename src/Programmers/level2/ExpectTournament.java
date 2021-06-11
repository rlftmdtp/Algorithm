package Programmers.level2;

public class ExpectTournament {

	public static void main(String[] args) {
		// TODO Auto-generated method st
		System.out.println(solution(8, 4, 5));
	}
	
    public static int solution(int n, int a, int b)
    {
        return tournament(n,a,b,1);

    }

	private static int tournament(int n, int a, int b, int i) {
		// TODO Auto-generated method stub
		if(n == 1) return -1;
		else if((a-b==1 && b%2==1)|| (b-a==1 && a%2==1)) return i; // 더 작은 수가 홀수인 조건까지 추가
		else {
			n = n/2;
			
			if(evenNumber(a)) a = a/2;
			else a = a/2 + 1;
			
			if(evenNumber(b)) b = b/2;
			else b = b/2 + 1;
			
			return tournament(n, a, b, i+1);
		}
	}

	private static boolean evenNumber(int a) {
		// TODO Auto-generated method stub
		if(a%2 == 0) return true;
		else return false;
	}

}
