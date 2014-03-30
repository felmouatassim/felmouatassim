package org.brilliant.farouk.TrickyTimers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.brilliant.farouk.common.ManageFiles;
import org.brilliant.farouk.common.ManageLists;

public class TrickyTimers {

	public static int getTime(List timesList, List timersTimesSet) {
		int i, j;
		int diff;
		int stop;
		for (i = 0; i <= 999; i++) {
			stop = 0;
			for (j = timersTimesSet.size() - 2; j >= 0; j--) {
				diff = ((Integer) timersTimesSet.get(timersTimesSet.size() - 1))
						.intValue()
						- ((Integer) timersTimesSet.get(j)).intValue();
				if (!timesList.contains(((Integer) timesList.get(i)).intValue()
						+ diff)) {
					stop = 1;
					break;
				}
				
			}
			if (stop == 0) {
				return ((Integer) timesList.get(i)).intValue()+((Integer) timersTimesSet.get(timersTimesSet.size() - 1))
						.intValue();
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List list = new ArrayList();
		list.add(new Integer("99").intValue());
		list.add(new Integer("55").intValue());
		list.add(new Integer("33").intValue());
		list.add(new Integer("10").intValue());
		// System.out.println(list.subList(0, list.size()/2));
		// System.out.println(list.get(list.size()-1));

		try {
			List<Integer> timesList = ManageFiles
					.readFiletoList("TrickyTimers_times.txt");
			List<Integer> timersTimesSet = ManageFiles
					.readFiletoListSaufZero("TrickyTimers_TimersTimes.txt");
			timersTimesSet = ManageLists.DivideAndConquer(timersTimesSet);

			System.out.println(timesList);
			System.out.println(timersTimesSet);
			for (int i = 0; i < 999; i++) {
				for (int j = i + 1; j < 1000; j++) {
					if ((((Integer) timesList.get(j)).intValue() - ((Integer) timesList
							.get(i)).intValue()) == (769873 - 761769 )) {
						//System.out.println(timesList.get(i));
						//System.out.println(timesList.get(j));
					}
				}
			}

			System.out.println(getTime(timesList, timersTimesSet));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
