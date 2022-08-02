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

		//  ��̺� �ο� ���� ���϶�
		// list.stream().flatMap(member -> member.get(0));
		HashMap<String, Integer> hm = new HashMap<>();
		list.stream()
			.flatMap(inerList -> Arrays.stream(inerList.get(1).split(":")))
			.forEach(hobby -> hm.merge(hobby, 1, (o,n) -> o++));
	
		
		// ��̺� ���� ���� ���� ��� ���� ���϶�
		HashMap<String, Integer> hm2 = new HashMap<>();
		list.stream()
			.filter(innerList -> innerList.get(0).startsWith("��"))
			.flatMap(innerList -> Arrays.stream(innerList.get(1).split(":")))
			.forEach(hobby -> hm2.merge(hobby, 1, (o,n) -> o++));
		hm2.keySet().forEach(key -> System.out.println(key + " " + hm2.get(key)));

		
		// �Ұ� ���뿡 '����'�� �� �� �����ϴ��� ���϶�
		Optional<Integer> sum = list.stream()
			.map(innserList -> likeCount(innserList.get(2)))
			.reduce((x,y) -> x+y);
		System.out.println(sum);		
			
	}
	
	public static int likeCount(String str) {
		Pattern p = Pattern.compile("����*");
		Matcher m = p.matcher(str);
		
		int count = 0;
		while(m.find()) count++;
		
		return count;
	}
	
	
	public static void makeData(List<List<String>> list) {
		List<String> data = new ArrayList<>();
		data.add("������");
		data.add("�౸:��:�߱�");
		data.add("�������� ���ƿ�");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("������");
		data.add("����:�籸:����");
		data.add("�����ϴµ� �ٱ� �Ⱦ�");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("�Ӹ��");
		data.add("�ǾƳ�");
		data.add("�Ҹ��� ���ƿ� �������Ƴʹ�����");
		list.add(data);
		
		data = new ArrayList<>();
		data.add("�Ҹ���");
		data.add("��������:����");
		data.add("�����ϴ� �Ҹ���");
		list.add(data);
	}

}
