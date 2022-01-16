package baekjoon.silver5;

import java.io.*;
import java.util.*;

public class Baekjoon_10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			pq.add(new Person(Integer.parseInt(strSplit[0]), strSplit[1], i));
		}
		
		while(!pq.isEmpty()) {
			Person p = pq.poll();
			System.out.println(p.age + " " + p.name);
		}
	}

}

class Person implements Comparable<Person>{
	int age;
	String name;
	int index;
	
	public Person(int age, String name, int index) {
		this.age = age;
		this.name = name;
		this.index = index;
	}
	
	public int compareTo(Person p) {
		
		if(this.age == p.age) {
			// 가입한 순서
			return this.index - p.index;
		}else return this.age - p.age;
	}
}
