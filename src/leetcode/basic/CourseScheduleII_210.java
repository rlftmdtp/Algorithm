package leetcode.basic;

import java.util.*;

public class CourseScheduleII_210 {
	public static int visitied[];
	public static Stack<Integer> st;
	public static boolean isTopology;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//		Output: [0,2,1,3]
//		Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//		So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
		
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		findOrder(numCourses, prerequisites);
	}
	
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
    	// 그래프 생성
    	Map<Integer, List<Integer>> graph = new HashMap<>();
    	// 그래프 초기화
    	for(int i=0; i<numCourses; i++) {
    		graph.put(i, new ArrayList<>());
    	}
    	
    	int indegree[] = new int[numCourses];
    	for(int i=0; i<prerequisites.length; i++) {
    		int cur = prerequisites[i][1];
    		int next = prerequisites[i][0];
    		
    		List<Integer> list = graph.getOrDefault(cur, new ArrayList<>());
    		list.add(next);
    		graph.put(cur, list);
    		indegree[next]++; 
    		// graph.getOrDefault(cur, new ArrayList<>()).add(next);
    	}
    	visitied = new int[numCourses];
    	isTopology = true;
    	st = new Stack<>();

    	// 위상 정렬 탐색방법 1.dfs, 2.inorder
    	// 1. dfs
//    	for(int i=0; i<graph.size(); i++) {
//    		if(visitied[i] == 0) {
//    			dfs(i, graph);
//    		}
//    	}
    	
    	// 2. indegree
    	Queue<Integer> q = new LinkedList<>();
    	for(int i=0; i<numCourses; i++) {
    		if(indegree[i] == 0) q.add(i);
    	}
    	
    	
    	while(!q.isEmpty()) {
    		int node = q.poll();
    		
    		
    	}
    	
    	
    	if(isTopology) {
    		int result[] = new int[numCourses];
    		int i = 0;
        	while(!st.isEmpty()) {
        		System.out.print(st.peek() + " ");
        		result[i++] = st.pop();
        	}
        	return result;
    	}else return new int[0];
    	
    }
    
    public static void dfs(int node, Map<Integer, List<Integer>> graph) {
    	visitied[node] = 1;

    	List<Integer> list = graph.get(node);
    	
    	for(int i=0; i<list.size(); i++) {
    		int next_node = list.get(i);
    		// System.out.println("node " + node + " next_node " + next_node ); 
    		if(visitied[next_node] == 0) dfs(next_node, graph);
    		else if(visitied[next_node] == 1){
    			// System.out.println("오류");
    			isTopology = false;
    			return;
    		}
    	}
    	
    	visitied[node] = 2;
    	st.add(node);
    }

}
