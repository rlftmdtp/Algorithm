package Programmers.level1;

import java.util.*;

public class Weekly4 {
	public static int grade[] = {0, 5,4,3,2,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7, 5, 5};
		
		solution(table, languages, preference);
	}
	
    public static String solution(String[] table, String[] languages, int[] preference) {
        // 이름이 사전 순으로 가장 빠른 직업군
        TreeSet<Developer> ts = new TreeSet<>();
        
        for(int i=0; i<table.length; i++) {
        	String s = table[i];
        	String split[] = s.split(" ");
        	
        	int totalgrade = 0;
        	for(int j=0; j<languages.length; j++) {
        		for(int z=1; z<split.length; z++) {
        			if(split[z].equals(languages[j])) {
        				totalgrade += grade[z] * preference[j];
        			}
        		}
        	}
        	//System.out.println(split[0] + " " + totalgrade);
        	ts.add(new Developer(split[0], totalgrade));
        }

        return ts.pollFirst().language;
    }

}

class Developer implements Comparable<Developer>{
	String language;
	int grade;
	
	Developer(String language, int grade){
		this.language = language;
		this.grade = grade;
	}

	@Override
	public int compareTo(Developer o) {
		// TODO Auto-generated method stub
		if(this.grade < o.grade) return 1;
		else if(this.grade == o.grade) {
			return this.language.compareTo(o.language);
		}else return -1;
	}
}
