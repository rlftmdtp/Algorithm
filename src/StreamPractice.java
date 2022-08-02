import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> list = new ArrayList<>();		
		makeData(list);

		//  취미별 인원 수를 구하라
		// list.stream().flatMap(member -> member.get(0));
		HashMap<String, Integer> hm = new HashMap<>();
		list.stream()
			.flatMap(inerList -> Arrays.stream(inerList.get(1).split(":")))
			.forEach(hobby -> hm.merge(hobby, 1, (o,n) -> o++));
	
		
		// 취미별 정씨 성을 갖는 멤버 수를 구하라
		HashMap<String, Integer> hm2 = new HashMap<>();
		list.stream()
			.filter(innerList -> innerList.get(0).startsWith("정"))
			.flatMap(innerList -> Arrays.stream(innerList.get(1).split(":")))
			.forEach(hobby -> hm2.merge(hobby, 1, (o,n) -> o++));
		hm2.keySet().forEach(key -> System.out.println(key + " " + hm2.get(key)));

		
		// 소개 내용에 '좋아'가 몇 번 등장하는지 구하라
		Optional<Integer> sum = list.stream()
			.map(innserList -> likeCount(innserList.get(2)))
			.reduce((x,y) -> x+y);
		System.out.println(sum);		
			
	}
	
	public static int likeCount(String str) {
		Pattern p = Pattern.compile("좋아*");
		Matcher m = p.matcher(str);
		
		int count = 0;
		while(m.find()) count++;
		
		return count;
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
