package Programmers.level3;

import java.util.*;
import java.util.regex.*;

public class Kakao2019BadUser {
	public static List<HashSet<String>> result = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		solution(user_id, banned_id);
	}
	
    public static int solution(String[] user_id, String[] banned_id) {
        // banned_id���� ������ ���̵� �̾Ƽ� ����Ʈ�� �����Ѵ�
        List<List<String>> ban_list = getBanCandidate(user_id, banned_id);
        
        // dfs�� �̹� �� ���� ���̵�� set���� �����ϸ鼭 �����
        dfs(ban_list, new HashSet<String>(),0);

        // System.out.println("���� ���� " + result.size());
        return result.size();
    }
    
    public static void dfs(List<List<String>> ban_list, HashSet<String> hs ,int depth) {
    	
    	if(ban_list.size() == depth) {
    		// ���� �ϼ�, ������ �̹� �����ϴ� ���̵������ �˻��Ѵ�			
    		boolean flag = true;
    		for(HashSet<String> re_hs : result) {
    			if(re_hs.containsAll(hs)) flag = false;
    		}
    		if(flag) {
    			result.add(new HashSet<String>(hs));
    		}
    	}else {
    			List<String> list = ban_list.get(depth);
    			for(int i=0; i<list.size(); i++) {
    				String ban_candidate = list.get(i);
    				if(!hs.contains(ban_candidate)) {
    					hs.add(ban_candidate);
        				dfs(ban_list, hs, depth+1);
        				hs.remove(ban_candidate);
    				}
    			}
    	}
    }
    
    public static List<List<String>> getBanCandidate(String[] user_id, String[] banned_id){
    	
    	List<List<String>> ban_list = new ArrayList<>();
        for(int i=0; i<banned_id.length; i++) {
        	String ban_id = banned_id[i].replace("*", ".");
        	// System.out.println("ban_id = " + ban_id);
        	List<String> ban_candidate = new ArrayList<>();
        	for(int j=0; j<user_id.length; j++) {
        		// System.out.println("user_id[" + j + "] " + user_id[j]);
            	boolean flag = Pattern.matches(ban_id, user_id[j]);
        		if(flag) ban_candidate.add(user_id[j]);
        	}
        	ban_list.add(ban_candidate);
        }
    	return ban_list;
    }

}
