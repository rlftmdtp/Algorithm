import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> list = new ArrayList<>();		
		makeData(list);

		//  취미별 인원 수를 구하라
		// list.stream().flatMap(member -> member.get(0));
		
		HashMap<String, Integer> hm = new HashMap<>();
		list.stream().map(member -> member.get(1).split(":")).forEach(member -> {
			for(int i=0; i<member.length; i++) {
				hm.put(member[i], hm.getOrDefault(member[i], 0)+1);
				// System.out.print(member[i] + " ");
			}
			// System.out.println();
		});
		
		// 취미별 정씨 성을 갖는 멤버 수를 구하라
		HashMap<String, Integer> hm2 = new HashMap<>();
		String test = "정지희";
		System.out.println(test.matches("^정.."));
		
		/*
		 * Pattern p = Pattern.compile("^정+"); Matcher m = p.matcher(test);
		 */
		
		
		list.stream().filter(member -> member.get(0).matches("^정+")).map(member -> member.get(1).split(":"))
			.forEach(member -> {
				for(int i=0; i<member.length; i++) {
					hm2.put(member[i], hm.getOrDefault(member[i], 0) + 1);
				}
			});
		
		hm2.entrySet().forEach(entry -> System.out.println(entry));
		
		// 소개 내용에 '좋아'가 몇 번 등장하는지 구하라
		Integer count = 0;
		list.stream().map(member -> member.get(2)).forEach(
				intro -> {
					Pattern p = Pattern.compile("좋아*");
					Matcher m = p.matcher(intro);
					
					// 일반 변순느 왜 안되는 거얌??
					while(m.find()) {
						count++;
					}
				});
		
		
	}
	
	
	public static void makeData(List<List<String>> list) {
		List<String> data = new ArrayList<>();
		data.add("김프로");
		data.add("축구:농구:야구");
		data.add("구기종목 좋아요");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("정프로");
		data.add("개발:당구:족구");
		data.add("개발하는데 뛰긴 싫어");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("앙몬드");
		data.add("피아노");
		data.add("죠르디가 좋아요 좋아좋아너무좋아");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("죠르디");
		data.add("스포츠댄스:개발");
		data.add("개발하는 죠르디");
		list.add(data);
	}

}
