import java.util.*;
import java.util.regex.*;

public class Test {
	
	public static void main(String[] args) {
	
	// �ִܰ�� 
    // https://www.codeup.kr/submitpage.php?id=3215&sid=16885638&rid=
	// �׷��� ����
	int V = 5; // ������ �ټ���
	List<Integer> graph[] = new ArrayList[V+1]; // ��尳��
	for(int i=1; i<=V; i++) {
		graph[i] = new ArrayList<>();
	}
	
	// ���� �ֱ� ���� ���� �� �־�� �Ѵ�
	List<Integer> list = new ArrayList<>();
	
	HashMap<Integer, Integer> hm = new HashMap<>();
	hm.put(null, null);
	hm.put(null, hm.getOrDefault(hm, 0)+1);
	for(int key : hm.keySet()) {
		hm.get(key);
	}
	
	}
	
}

class Node implements Comparable<Node>{
	int v;
	int d;
	
	public Node(int v, int d) {
		this.v = v;
		this.d = d;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.v - o.v;
		// ������������
	}

}


