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

           // ������ ��ųƮ�� ������ � �ΰ�?
           for(int i=0; i<skill_trees.length; i++) {
               // ť �ʱ�ȭ
               Queue<Character> st_skill = new LinkedList<Character>();
               for(int z=0; z<skill.length(); z++) {
                   st_skill.add(skill.charAt(z));
               }

               String skill_tree = skill_trees[i];
               boolean flag = true;


               // �ش� ��ų�� �����ϰ� ������ ���鼭 �˻縦 �غ���
               for(int j=0; j<skill_tree.length(); j++) {
                   if(st_skill.contains(skill_tree.charAt(j))) {
                       if(st_skill.peek() != skill_tree.charAt(j)) flag = false; // ���� ������ Ʋ��
                       st_skill.poll();
                   }
               }
               if(flag) {
                   System.out.println(i);
                   answer ++; // �ùٸ� ��ųƮ�� ����
               }
           }

           return answer;
    }
}
