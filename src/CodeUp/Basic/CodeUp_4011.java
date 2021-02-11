package CodeUp.Basic;

import java.io.*;

public class CodeUp_4011 { // 생년월일 출력

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split("-");
		char ch1[] = strSplit[0].toCharArray();
		char ch2[] = strSplit[1].toCharArray();
		String result = "";
		String sex = "";
		
		switch (ch2[0]) {
		case '1': {
			result += "19" + ch1[0] + ch1[1] + "/" + ch1[2] + ch1[3] + "/" + ch1[4] + ch1[5] + " " + "M";
			break;
		}
		case '2': {
			result += "19" + ch1[0] + ch1[1] + "/" + ch1[2] + ch1[3] + "/" + ch1[4] + ch1[5] + " " + "F";
			break;
		}
		case '3': {
			result += "20" + ch1[0] + ch1[1] + "/" + ch1[2] + ch1[3] + "/" + ch1[4] + ch1[5] + " " + "M";
			break;
		}
		case '4': {
			result += "20" + ch1[0] + ch1[1] + "/" + ch1[2] + ch1[3] + "/" + ch1[4] + ch1[5] + " " + "F";
			break;
		}
		}
		
		System.out.println(result);
		
		
		
	}

}
