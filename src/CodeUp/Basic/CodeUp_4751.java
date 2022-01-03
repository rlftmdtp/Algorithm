package CodeUp.Basic;

import java.util.*;
import java.io.*;

public class CodeUp_4751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Student> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			int nation = Integer.parseInt(strSplit[0]);
			int st_number = Integer.parseInt(strSplit[1]);
			int grade = Integer.parseInt(strSplit[2]);
			// 국가번호 학생번호 점수
			list.add(new Student(nation, st_number, grade));
		}
		
		// 점수 내림차순 정렬
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.grade - o1.grade;
			}
			
		});
		
		List<String> result = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(Student st : list) {
			if(result.size() == 3) break;
			else {
				if(hm.getOrDefault(st.nation, 0) < 2) {
					result.add(st.nation + " " + st.st_number);
					hm.put(st.nation, hm.getOrDefault(st.nation, 0) + 1);
				}
			}
		}
		
		for(String str : result) {
			System.out.println(str
					
					);
		}
		
	}
}

class Student{
	int nation;
	int st_number;
	int grade;
	
	public Student(int nation, int st_number, int grade) {
		this.nation = nation;
		this.st_number = st_number;
		this.grade = grade;
	}
}
