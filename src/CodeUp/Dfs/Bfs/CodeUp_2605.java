package CodeUp.Dfs.Bfs;

import java.io.*;

public class CodeUp_2605 {
	public static int MAX = 7;
	public static int BUMB = 3;
	public static int result = 0;
	
	public static int candiPang[][] = new int[MAX][MAX];
	public static int check[][] = new int[MAX][MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<MAX; i++){
			String st = br.readLine();
			String stSplit[] = st.split("\\s");

			for(int j=0; j<stSplit.length; j++){
				candiPang[i][j] = Integer.parseInt(stSplit[j]);
			}
		}
		
		for(int i=0; i<MAX; i++){
			int tmp[] = candiPang[i];
			for(int j=0; j<MAX; j++){
				int color = tmp[j];
				int colorCount = dfs(i, j, color);
				if(colorCount >= BUMB){
					result += 1;
				}
			}
		}
		System.out.println(result);
	}
	
	public static int dfs(int i, int j, int color){
		// 맵의 크기  , 동일 색깔 유무, 방문유무
		if(i >= MAX || j >= MAX || i < 0 || j < 0){
			return 0;
		}else if(color != candiPang[i][j]){
			return 0;
		}else if(check[i][j] == 1){
			return 0;
		}
		else{
			check[i][j] = 1;
			return 1 + dfs(i-1, j, color) + dfs(i, j+1, color) + dfs(i+1, j, color) + dfs(i, j-1, color);
		}
	}
}
