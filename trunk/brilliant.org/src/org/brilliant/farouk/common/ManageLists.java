package org.brilliant.farouk.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ManageLists {
	public static List<Integer> DivideAndConquer(List<Integer> list) {

		List<Integer> halfList1 = new ArrayList<Integer>();
		List<Integer> halfList2 = new ArrayList<Integer>();

		if (list.size() <= 1) {
			return list;
		} else {
			halfList1 = list.subList(0, list.size() / 2);
			halfList2 = list.subList(list.size() / 2, list.size());
			List sortedList = conquer(new LinkedList(
					DivideAndConquer(halfList1)), new LinkedList(
					DivideAndConquer(halfList2)));
			return sortedList;
		}

	}

	public static List<Integer> conquer(LinkedList<Integer> list1,
			LinkedList<Integer> list2) {
		List<Integer> list = new ArrayList<Integer>();

		Integer value1 = null;
		Integer value2 = null;
		while (!list1.isEmpty() && !list2.isEmpty()) {
			value1 = list1.getFirst();
			value2 = list2.getFirst();
			if (value1.intValue() < value2.intValue()) {
				list.add(value1);
				list1.removeFirst();
			} else if (value2.intValue() < value1.intValue()) {
				list.add(value2);
				list2.removeFirst();
			} else if (value1.intValue() == value2.intValue()) {
				list.add(value1);
				list.add(value2);
				list1.removeFirst();
				list2.removeFirst();
			}
		}
		if (list1.isEmpty()) {
			list.addAll(list2);
		} else if (list2.isEmpty()) {
			list.addAll(list1);
		}

		return list;

	}
}
