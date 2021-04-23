package Programmers.level2;

public class TargetNumber {
	
	public static boolean visited[];
	public static int total = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}


    public static int solution(int[] numbers, int target) {
        
        return dfs(0, 0, numbers, target);
    }
    
    public static int dfs(int n, int sum, int[] numbers, int target){
        if(n == numbers.length){
            if(sum == target) return 1;
            else return 0;
        }
        else{
            return dfs(n+1, sum+numbers[n], numbers, target ) + dfs(n+1, sum-numbers[n], numbers, target );
        }
    }

}
