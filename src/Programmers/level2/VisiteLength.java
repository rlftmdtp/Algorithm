package Programmers.level2;

public class VisiteLength {
	public static int result = 0;
	public static int visited[][] = new int[100][100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dirs = "ULURRDLLU";
		solution(dirs);
	}
	
    public static int solution(String dirs) {
        int answer = 0;
        
        System.out.println(-1-2);
        
        int x = 5;
        int y = 5;

        for(int i=0; i<dirs.length(); i++) {
        	char d = dirs.charAt(i);
        	
    		int nx = x;
    		int ny = y;
        	
        	if(d == 'U') {
        		nx = x+1;
        		ny = y;
        	}else if(d == 'D') {
        		nx = x-1;
        		ny = y;
        	}else if(d == 'R') {
        		nx = x;
        		ny = y+1;
        	}else { // L
        		nx = x;
        		ny = y-1;
        	}
        	
        	checkVisit(x,y,nx,ny);
        }
        
        System.out.println(result + " result");
        return answer;
    }
    
    public static void checkVisit(int x, int y, int nx, int ny) {
    	System.out.println("checkVisit "  + x + " " + y);
    	if(visited[x][y] == 0) {
    		result++;
    		visited[x][y] = 1;
    	}
    }

}
