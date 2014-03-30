package org.brilliant.farouk.level5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RetrieveList {

	public static void main(String[] args) throws Exception {

		FileInputStream io = new FileInputStream("ListFile.txt");
		InputStreamReader isr = new InputStreamReader(io);
		BufferedReader fr = new BufferedReader(isr);
		String ligne;
		List list = new ArrayList<Integer>();
		while ((ligne = fr.readLine()) != null){
			//System.out.println(ligne.toString());
			list.add(new Integer(ligne));
		}
		//int s = list.size();
		//System.out.println(list.get(0));
		Integer number;
		
		List rightList = new ArrayList<Integer>();
		List tempList = new ArrayList<Integer>();
		int s=1;
		tempList.add((Integer) list.get(0));
		while (s<list.size()){
			
			if (((Integer) list.get(s)) > ((Integer) list.get(s-1))){
				tempList.add((Integer) list.get(s));
			}else{
				if (tempList.size()>rightList.size()){
					rightList.clear();
					rightList.addAll(tempList);
					tempList.clear();
					tempList.add((Integer) list.get(s));
				} else {
					tempList.clear();
					tempList.add((Integer) list.get(s));
				}
			}
			s++;
		}
		
		int i=0;
		int total = 0;
		System.out.println(rightList);
		while (i <rightList.size()){
			total += ((Integer)rightList.get(i)).intValue();
			i++;
		}
		System.out.println(total);
		
		return;
		
	}

}
