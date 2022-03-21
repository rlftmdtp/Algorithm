import java.util.*;
import java.util.regex.*;

public class Test {
	public static int[] list;
	public static void main(String[] args) {
		solution(18);
	}
	
	public static int[] solution(int n) {
		
		list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = i+1;
		}
		
		// 머지소트? log2n
		
		// 가장 작은 소수 찾기
		mergeSort(0, n);
				
		return null;
	}
	
	public static void mergeSort(int st, int en) {
		int mid = (st+en)/2;
		
		// len = 1 이라면 과정 종료
		if(mid != 1) {
			System.out.println("st " + st + "  en " + en + " mid " + mid);			

			merge(st, en, mid);
			mergeSort(st, mid);
			// mergeSort(mid+1, en);
		}
	}
	
	public static void merge(int st, int en, int mid) {
		int tmp[] = new int[en];

		for(int i=st; i<en; i++) {
			System.out.print(list[i] + " ");
			if(i%2 == 0) tmp[st++] = list[i];
			else tmp[mid++] = list[i];
		}
		System.out.println();
		
		for(int i=0; i<tmp.length; i++) {
			list[i] = tmp[i];
		}
		
		System.out.println("정렬된 결과 ");
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	public static int findPrime(int len) {
		
		int st = 2;
		while(true) {
			if(len%st == 0) return st;
			st++;
		}
	}
	
}

