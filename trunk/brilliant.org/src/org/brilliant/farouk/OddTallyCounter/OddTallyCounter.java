package org.brilliant.farouk.OddTallyCounter;

import java.util.ArrayList;

public class OddTallyCounter {

	public static ArrayList insertIfDifferent(ArrayList list,int a){
		int exist=0;
		for (int i=0; i<list.size();i++){
			if((Integer) list.get(i) == a){
				exist = 1;
			}
		}
		if (exist == 0){
			list.add(a);
		}
		return list;
	}
	public static int f(int x){

		int number=0;
		int j;
		ArrayList list=new ArrayList(10000);
		Integer k;
		int length;
		
		for (j=1;j<=10000;j++){
			k=new Integer(j*x);
			length = k.toString().length();
			if (length>4){
				k = new Integer(k.toString().substring(length-4,length));
			}
			insertIfDifferent(list,k);
		}
		return list.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		int i;
		for(i=1;i<=9999;i++){
			
			total =total + f(i);
		}
		
		System.out.println(total);
	}

}
