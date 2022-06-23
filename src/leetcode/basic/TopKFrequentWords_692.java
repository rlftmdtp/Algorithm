package leetcode.basic;

import java.io.*;
import java.util.*;

public class TopKFrequentWords_692 {

    static class Word implements Comparable<Word>{
    	String str;
    	int count;
    	
    	public Word(String str, int count) {
    		this.str = str;
    		this.count = count;
    	}

		@Override
		public int compareTo(Word o) {
			// TODO Auto-generated method stub
			if(this.count == o.count) {
				return this.str.compareTo(o.str);
			}else return o.count - this.count;
		}
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"i","love","leetcode","i","love","coding"};
		int k = 2;
		topKFrequent(words, k);
	}
	
    public static List<String> topKFrequent(String[] words, int k) {
        
    	// 우선순위 큐 만들기
    	
    	// 가장 많이 나온 단어가 정답으로 나온다 ( 순서가 같은 경우 문자순 )
    	PriorityQueue<Word> pq = new PriorityQueue<>();
    	
    	Map<String, Integer> hm = new HashMap<>();
    	for(String word : words) {
    		hm.put(word, hm.getOrDefault(word, 0) + 1);
    	}
    	
    	for(String key : hm.keySet()) {
    		pq.add(new Word(key, hm.get(key)));
    	}
    	
    	List<String> result = new ArrayList<>();
    	for(int i=0; i<k; i++) {
    		// System.out.println(pq.poll().str);
    		result.add(pq.poll().str);
    	}
    	return result;
    }
    
}
