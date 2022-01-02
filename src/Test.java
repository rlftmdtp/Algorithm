import java.util.*;
import java.util.regex.*;

public class Test {
	
	public static void main(String[] args) {
	
	// 최단경로 
    // https://www.codeup.kr/submitpage.php?id=3215&sid=16885638&rid=
	// 그래프 문제
	int V = 5; // 정점이 다섯개
	List<Integer> graph[] = new ArrayList[V+1]; // 노드개수
	for(int i=1; i<=V; i++) {
		graph[i] = new ArrayList<>();
	}
	
	// 에지 넣기 양쪽 방향 다 넣어야 한다
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
		// 오름차순정렬
	}

}


