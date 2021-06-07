package Programmers.level2;

public class KakaoColoringBook {
    public static boolean visitied[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int picture[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(solution(6, 4, picture));
	}
	
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visitied = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		int f = findArea(picture[i][j],i,j,m,n,picture);
        		if(maxSizeOfOneArea < f) maxSizeOfOneArea = f;
        		if(f > 0) numberOfArea++;
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(numberOfArea + " " + maxSizeOfOneArea);
        return answer;
    }
    
	private static int findArea(int beforeColor, int i, int j, int m, int n, int[][] picture) {
		// TODO Auto-generated method stub	
		if(i>=m || j>=n || i<0 || j<0) return 0; // 그림판 크기 영역
		else if(visitied[i][j] == true || picture[i][j] == 0) return 0; // 이미확인한 곳 혹은 색칠안되어있는 영역
		else if(beforeColor != picture[i][j]) return 0;// 이전과 색깔이 다르다면
		else {
			beforeColor = picture[i][j];
			visitied[i][j] = true;
			return 1 + findArea(beforeColor, i-1, j, m, n, picture) + findArea(beforeColor, i, j+1, m, n, picture)
			 + findArea(beforeColor, i+1, j, m, n, picture) + findArea(beforeColor, i, j-1, m, n, picture);
		}	
	}

}
