import java.util.*;

import javax.swing.text.DateFormatter;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {
	public static int result[] = new int[5];
	public static class Log implements Comparable<Log>{
		LocalDate date;
		String act;
		int price;
		
		public Log(LocalDate date, String act, int price) {
			this.date = date;
			this.act = act;
			this.price = price;
		}
		
		public int compareTo(Log l) {
			return date.compareTo(l.date);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		// String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
		solution(purchase);
	}
	
	public static int solution(String[] purchase) {
		
		PriorityQueue<Log> pq = new PriorityQueue<>();
		// 첫 시작과 끝을 넣는다
		pq.add(new Log(parseDate("2019/01/01"), "IN", 0));
		pq.add(new Log(parseDate("2019/12/31"), "IN", 0));
		
		for(int i=0; i<purchase.length; i++) {
			String strSplit[] = purchase[i].split(" ");
			LocalDate ld = parseDate(strSplit[0]);
			LocalDate ld_plus_month = ld.plusDays(30);
			
			pq.add(new Log(ld, "IN", Integer.parseInt(strSplit[1])));
			pq.add(new Log(ld_plus_month, "OUT", Integer.parseInt(strSplit[1])));
		}
		
		int sum = 0;
		while(!pq.isEmpty()) {
			Log l = pq.poll();
			
			if(!pq.isEmpty()) {
				Log next_l = pq.peek();
				System.out.println("l.date " + l.date);
				System.out.println("next_l.date " + next_l.date);
				long date_gap = ChronoUnit.DAYS.between(l.date, next_l.date);
				
				// sum을 기준으로 등급을 매긴다
				result[rankCechk(sum)] += date_gap;
				
				System.out.println("## date_gap " + date_gap);
				System.out.println("## sum " + sum);
				System.out.println("## rankCheck " + rankCechk(sum));
				
				if(next_l.act.equals("IN"))	sum += next_l.price;
				else sum -= next_l.price;
			}
		}
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		return 0;
	}
	
	public static int rankCechk(int sum) {
		if(sum >= 0 && sum < 10000) return 0;
		else if(sum >= 10000 && sum < 20000) return 1;
		else if(sum >= 20000 && sum < 50000) return 2;
		else if(sum >= 50000 && sum < 100000) return 3;
		else return 4;
	}
	
	public static LocalDate parseDate(String str) {
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ld = LocalDate.parse(str, fm);
		ld.plusMonths(30);
		return ld;
	}


}
