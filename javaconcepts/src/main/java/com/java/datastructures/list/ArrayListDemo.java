package com.java.datastructures.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	private static List<Integer> integerList = new ArrayList<>();

	public static void main(String[] arg) {
		integerList.add(12);
		integerList.add(13);
		integerList.add(14);
		integerList.add(15);
		integerList.add(16);
		integerList.add(17);
		integerList.add(18);

		/*
		 * Throws ConcurrentModificationException if try to modify the list while
		 * iterating on it.
		 * 
		 * Iterator<Integer> itr = integerList.iterator(); while(itr.hasNext()) {
		 * Integer number = itr.next(); if (number <= 13) { integerList.remove(number);
		 * } }
		 */

		/*
		 * Throws ConcurrentModificationException if try to modify the list while
		 * iterating on it.
		 * 
		 * for (Integer i : integerList) { if (i <= 13) { integerList.remove(i); } }
		 */

		/*
		 * Throws ConcurrentModificationException if try to modify the list while
		 * iterating on it.
		 * 
		 * ListIterator<Integer> it = integerList.listIterator(); while (it.hasNext()) {
		 * Integer nextInt = it.next(); if (nextInt <= 13) {
		 * integerList.remove(nextInt); } }
		 */
		
		//Does not throw any exception
		Iterator<Integer> itr = integerList.iterator();
		while (itr.hasNext()) {
			Integer number = itr.next();
			if (number <= 13) {
				itr.remove();
			}
		}
		System.out.println(integerList);
	}

}
