package com.category.simple;

import java.util.ArrayList;
import java.util.List;
/**Program to evaluate the bracket Expression
 * Time Complexity: O(n) where n is number of characters in the input expression.
 * Space Complexity: O(n) where n is number of characters in the input expression.
 * */
public class BalancedBrackets {

	private static List<Character> charStack;
	private static boolean balancedExpression = true;

	public static boolean isBalancedExpression(String expression) {
		balancedExpression=true;
		charStack = new ArrayList<>(expression.length());
		int counter = 0;
		while (counter < expression.length()) {
			char tmpChar = expression.charAt(counter);
			if (tmpChar == '(' || tmpChar == '{' || tmpChar == '[') {
				charStack.add(tmpChar);
			}
			if (tmpChar == ')' || tmpChar == '}' || tmpChar == ']') {
				closeBracketOperation(tmpChar);
				if (!balancedExpression)
					break;
			}
			counter++;
		}
		if(charStack.size()!=0) {
			balancedExpression=false;
		}
		return balancedExpression;
	}

	private static void closeBracketOperation(char bracket) {
		if (charStack.size() == 0) {
			balancedExpression = false;
			return;
		}
		Character tmpChar = charStack.remove(charStack.size() - 1);
		if (!(bracket == '}' && tmpChar == '{') && !(bracket == ')' && tmpChar == '(')
				&& !(bracket == ']' && tmpChar == '[')) {
			balancedExpression = false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isBalancedExpression("({[]{}()})"));
		System.out.println(isBalancedExpression("(((((("));
		System.out.println(isBalancedExpression("({[]{}()}"));
		System.out.println(isBalancedExpression("({[]{}({})})"));
		
	}
}
