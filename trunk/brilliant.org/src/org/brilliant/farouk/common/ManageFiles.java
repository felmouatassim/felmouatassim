package org.brilliant.farouk.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ManageFiles {

	public static Set<Integer> readFiletoSet(String filename)
			throws IOException {

		FileInputStream is = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(isr);
		Integer number;
		Set<Integer> set = new HashSet<Integer>();
		String ligne;
		while ((ligne = bf.readLine()) != null) {
			number = new Integer(ligne);
			set.add(number);
		}
		bf.close();
		return set;

	}

	public static List readFiletoList(String filename)
			throws IOException {

		FileInputStream is = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(isr);
		int number;
		List<Integer> list = new ArrayList<Integer>();
		String ligne;
		while ((ligne = bf.readLine()) != null) {
			number = new Integer(ligne).intValue();
			list.add(number);
		}
		bf.close();
		return list;

	}

	public static List readFiletoListSaufZero(String filename)
			throws IOException {

		FileInputStream is = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(isr);
		int number;
		List<Integer> list = new ArrayList<Integer>();
		String ligne;
		while ((ligne = bf.readLine()) != null) {
			number = new Integer(ligne).intValue();
			if (number != 0) {
				list.add(number);
			}
		}
		bf.close();
		return list;

	}

}
