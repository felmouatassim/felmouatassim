package org.brilliant.farouk.BeautifulNumbers;

import java.util.BitSet;

public class BeautifulNumbers {

	public static int getBeauty(int n){
		
		String binary=new String();
		int ntmp;
		ntmp=n;
		int i;
		int value;
		int beauty=0;
		for (i=9; i>=0;i--){
			
			value = (int)(ntmp/(Math.pow(2,i)));
			if (value == 1){
				beauty++;
			}
			binary = binary.concat(Integer.toString(value));
			ntmp=ntmp- value*((int) Math.pow(2,i));
		}
		//System.out.println(binary);
		return beauty;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for (i=999;i>=100;i--){
			if (getBeauty(i)== getBeauty(271)){
				System.out.println(i);
				return;
			}
		}
		
	}

}
