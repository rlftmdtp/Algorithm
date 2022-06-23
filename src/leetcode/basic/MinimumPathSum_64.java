package leetcode.basic;

public class MinimumPathSum_64 {
	public static boolean visitied[][];
	public static int direct_x[] = {0, 1};
	public static int direct_y[] = {1, 0};
	public static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
		minPathSum(grid);	
	}
	
    public static int minPathSum(int[][] grid) {
    	visitied = new boolean[grid.length][grid[0].length];
		// dfs로 전부 탐색해서 가장 작은 값으로..?
    	dfs(0,0,grid, grid[0][0]);
    	// System.out.println("정답 = " + result);
    	return result;
    }
    
    public static void dfs(int x, int y, int[][] grid, int sum) {
    	
    	if(x == grid.length-1 && y == grid[0].length-1) {
    		// System.out.println("x  = " + x + " y " + y + " sum = " + sum);
    		result = Math.min(result, sum);
    	}else {
        	// visitied[x][y] = true;
        	for(int i=0; i<2; i++) {
        		int new_x = x + direct_x[i];
        		int new_y = y + direct_y[i];
        		
        		// 맵 범위확인
        		if(new_x >= 0 && new_x<grid.length && new_y >= 0 && new_y<grid[0].length) {
        			dfs(new_x, new_y, grid, sum+grid[new_x][new_y]);
        		}
        	}	
    	}
    }

}
