package Programmers.level2;

import java.util.*;

public class SkillTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		solution(skill, skill_trees);
	}
	
    public static int solution(String skill, String[] skill_trees) {
    	   int answer = 0;

           // 가능한 스킬트리 개수가 몇개 인가?
           for(int i=0; i<skill_trees.length; i++) {
               // 큐 초기화
               Queue<Character> st_skill = new LinkedList<Character>();
               for(int z=0; z<skill.length(); z++) {
                   st_skill.add(skill.charAt(z));
               }

               String skill_tree = skill_trees[i];
               boolean flag = true;


               // 해당 스킬을 포함하고 있으면 빼면서 검사를 해본다
               for(int j=0; j<skill_tree.length(); j++) {
                   if(st_skill.contains(skill_tree.charAt(j))) {
                       if(st_skill.peek() != skill_tree.charAt(j)) flag = false; // 선행 순서가 틀림
                       st_skill.poll();
                   }
               }
               if(flag) {
                   System.out.println(i);
                   answer ++; // 올바른 스킬트리 구성
               }
           }

           return answer;
    }
}
