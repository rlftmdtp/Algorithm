package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Warehouse_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Square> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			String splitStr[] = br.readLine().split(" ");
			q.add(new Square(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[1])));
		}
		
		int result = 0;
		while(!q.isEmpty()) {
			Square sq = q.poll();
			System.out.println("sq.l " + sq.l);
			PriorityQueue<Integer> pq_l = new PriorityQueue<>();
			PriorityQueue<Integer> pq_h = new PriorityQueue<>();
			
			// 1. �ڽź��� ���� ���� ã�´�
			int count = 0;
			for(Square sq2 : q) {
				// System.out.println("sq2.l " + sq2.l);
				pq_l.add(sq2.l);
				pq_h.add(sq2.h);
				if(sq.h < sq2.h) {
					System.out.println("1�� ��� ���� " + ((sq2.l - sq.l) * sq.h));
					result += (sq2.l - sq.l) * sq.h;
					break;
				}
				count++;
			}
			
			// 2. �ڱ⺸�� ������ ���� ���
			// �� ���� ���� ���̸� �˾ƾ��Ѵ�
			if(count == q.size()) {
				int nextH = pq_h.poll();
				// �� ���� ���� ����
				result += (pq_l.poll() - sq.l+1) * nextH + (sq.h-nextH);
			}
			
			// count ��ŭ ����
			for(int i=0; i<count; i++) {
				q.poll();
			}
			
		}
		System.out.println(result);
	}

}

class Square implements Comparable<Square>{
	int l;
	int h;
	
	public Square(int l, int h){
		this.l = l;
		this.h  = h;
	}

	@Override
	public int compareTo(Square o) {
		// TODO Auto-generated method stub
		// l�� ���� ������
		return this.l - o.l;
	}
}
