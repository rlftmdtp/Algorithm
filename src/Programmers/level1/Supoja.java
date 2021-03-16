package Programmers.level1;

import java.util.*;

public class Supoja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] solution(int[] counts) {
        int[] count = {0,0,0};
        
        int supo1[] = {1,2,3,4,5};
        int supo2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int supo3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<counts.length; i++) {
        	if(counts[i] == supo1[i%(supo1.length-1)]) count[0] += 1;
        	if(counts[i] == supo2[i%(supo2.length-1)]) count[1] += 1;
        	if(counts[i] == supo3[i%(supo3.length-1)]) count[2] += 1;
        }
        
        int max = 0;
        for(int i=0; i<count.length; i++) {
        	if(count[i] > max) max = count[i];
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<count.length; i++) {
        	if(max == count[i]) list.add(i);
        }
        
        int result[] = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	result[i] = list.get(i)+1;
        }
        
        Arrays.sort(result);
        return result;
    }
}
