import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> list = new ArrayList<>();		
		makeData(list);

		//  ��̺� �ο� ���� ���϶�
		// list.stream().flatMap(member -> member.get(0));
		
		HashMap<String, Integer> hm = new HashMap<>();
		list.stream().map(member -> member.get(1).split(":")).forEach(member -> {
			for(int i=0; i<member.length; i++) {
				hm.put(member[i], hm.getOrDefault(member[i], 0)+1);
				// System.out.print(member[i] + " ");
			}
			// System.out.println();
		});
		
		// ��̺� ���� ���� ���� ��� ���� ���϶�
		HashMap<String, Integer> hm2 = new HashMap<>();
		String test = "������";
		System.out.println(test.matches("^��.."));
		
		/*
		 * Pattern p = Pattern.compile("^��+"); Matcher m = p.matcher(test);
		 */
		
		
		list.stream().filter(member -> member.get(0).matches("^��+")).map(member -> member.get(1).split(":"))
			.forEach(member -> {
				for(int i=0; i<member.length; i++) {
					hm2.put(member[i], hm.getOrDefault(member[i], 0) + 1);
				}
			});
		
		hm2.entrySet().forEach(entry -> System.out.println(entry));
		
		// �Ұ� ���뿡 '����'�� �� �� �����ϴ��� ���϶�
		Integer count = 0;
		list.stream().map(member -> member.get(2)).forEach(
				intro -> {
					Pattern p = Pattern.compile("����*");
					Matcher m = p.matcher(intro);
					
					// �Ϲ� ������ �� �ȵǴ� �ž�??
					while(m.find()) {
						count++;
					}
				});
		
		
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
