package Programmers.level2;

import java.util.*;
import java.util.regex.*;

public class Tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		solution(s);
	}
	
    public static int[] solution(String s) {
        
        Pattern p = Pattern.compile("\\{[0-9,]+\\}");
        Matcher m = p.matcher(s);
        
        List<String> list = new ArrayList<>();
        while(m.find()) {
        	list.add(m.group(0));
        }
        
        Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
        
        int answer[] = new int[list.size()];
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<list.size(); i++) {
        	String strList = list.get(i);
        	
        	p = Pattern.compile("[0-9]+");
        	m = p.matcher(strList);

            while(m.find()) {
            	if(!hs.contains(m.group(0))) {
            		answer[i] = Integer.parseInt(m.group());
            		hs.add(m.group());
            	}
            }
            

        	
        }
        
		/*
		 * for(int result : answer) { System.out.println("정답순서 " + result); }
		 */

        return answer;
    }

}
