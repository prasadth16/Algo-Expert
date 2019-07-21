package com.category.simple.datastructures.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Program to create String suffix data structure.
 * 
 **/
public class SuffixTreeDataStructure {
	private static Node rootNode = new Node(false);

	static class Node {
		private Map<Character, Node> children;
		private Boolean endOfSuffix;

		public Node(Boolean endOfSuffix) {
			children = new HashMap<Character, SuffixTreeDataStructure.Node>();
			this.endOfSuffix = endOfSuffix;
		}

		public Map<Character, Node> getChildren() {
			return children;
		}

		public Boolean getEndOfSuffix() {
			return endOfSuffix;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((children == null) ? 0 : children.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (children == null) {
				if (other.children != null)
					return false;
			} else if (!children.equals(other.children))
				return false;
			return true;
		}

		/**
		 * This Method adds all the suffixes in the input string to the suffix tree.
		 * Time Complexity: O(m^2) where m is the number of characters in the given
		 * string. It is m2 because we are iterating over the string with the nested
		 * loop. Space complexity: O(m^2) as in worst case if there are no repetetion
		 * then there will be almost M^2 nodes in the tree.
		 **/
		public static void AddStringToSuffixTree(String ipString) {
			int mainCounter = 0;
			int suffixCounter = 0;

			while (mainCounter < ipString.length()) {
				suffixCounter = mainCounter;
				Node currentNode = rootNode;
				Node newNode = null;
				if (mainCounter == ipString.length() - 1) {
					if (rootNode.getChildren().containsKey(ipString.charAt(mainCounter))) {
						currentNode = rootNode.getChildren().get(ipString.charAt(mainCounter));
						currentNode.endOfSuffix = false;
					} else {
						newNode = new Node(true);
						rootNode.getChildren().put(ipString.charAt(mainCounter), newNode);
					}
				} else {
					while (suffixCounter < ipString.length()) {
						if (currentNode.getChildren().containsKey(ipString.charAt(suffixCounter))) {
							currentNode = currentNode.getChildren().get(ipString.charAt(suffixCounter));
						} else {
							if (suffixCounter == ipString.length() - 1)
								newNode = new Node(true);
							else
								newNode = new Node(false);
							currentNode.getChildren().put(ipString.charAt(suffixCounter), newNode);

						}
						suffixCounter++;
					}
				}
				mainCounter++;
			}
		}

		/**
		 * Method to search string in the suffix tree Time Complexity:O(M) where m are
		 * the number of characters in the string Space Complexity: constant space.
		 **/
		public static boolean searchStringInSuffixTree(String ipString) {
			int stringCounter = 0;
			boolean stringFound = true;
			Node currentNode = rootNode;
			while (stringCounter < ipString.length()) {
				if (stringCounter == ipString.length() - 1
						&& !currentNode.getChildren().get(ipString.charAt(stringCounter)).endOfSuffix) {
					stringFound = false;
				} else {
					if (currentNode.getChildren().containsKey(ipString.charAt(stringCounter))) {
						currentNode = currentNode.getChildren().get(ipString.charAt(stringCounter));
					} else {
						stringFound = false;
						break;
					}
				}
				stringCounter++;
			}
			return stringFound;
		}

	}
}
