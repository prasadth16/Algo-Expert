package com.category.simple.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to Implement Min-Max Stack with all the operations in constant time
 * and space. Time Complexity: O(1) Space Complexity: O(1)
 **/
public class MinMaxStack {
	private List<StackInteger> stack = new ArrayList<>();

	static class StackInteger {
		private int value;
		private int maxValue;
		private int minValue;

		public StackInteger(int value, int maxValue, int minValue) {
			this.value = value;
			this.maxValue = maxValue;
			this.minValue = minValue;
		}

		public int getValue() {
			return value;
		}

		public int getMaxValue() {
			return maxValue;
		}

		public int getMinValue() {
			return minValue;
		}

	}

	public void push(int value) {
		StackInteger si = null;
		int minValue = 0;
		int maxValue = 0;
		if (stack.size() == 0) {
			si = new StackInteger(value, value, value);
			stack.add(si);
		} else {
			minValue = stack.get(stack.size() - 1).getMinValue() > value ? value
					: stack.get(stack.size() - 1).getMinValue();
			maxValue = stack.get(stack.size() - 1).getMaxValue() < value ? value
					: stack.get(stack.size() - 1).getMaxValue();
			si = new StackInteger(value, maxValue, minValue);
			stack.add(si);
		}
	}

	public int pop() {
		StackInteger si = stack.remove(stack.size() - 1);
		return si.getValue();
	}

	public int peek() {
		return stack.get(stack.size() - 1).getValue();
	}

	public int getMaxOnStack() {
		return stack.get(stack.size() - 1).getMaxValue();
	}

	public int getMinOnStack() {
		return stack.get(stack.size() - 1).getMinValue();
	}
}
