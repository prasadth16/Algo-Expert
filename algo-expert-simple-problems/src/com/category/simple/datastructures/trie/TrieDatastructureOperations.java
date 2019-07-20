package com.category.simple.datastructures.trie;

import java.util.HashMap;
import java.util.Map;
/**Trie data structure operations(insert, delete search)
 * Time Complexity of all the operations: O(n) where n is the number of characters in the string
 * Space complexity: wost case O(m*n) where m are average number of characters in the string and n is number of strings in Trie.
 * 
 * **/

public class TrieDatastructureOperations {
	private static Node parentNode = new Node(false);

	static class Node {
		Map<Character, Node> children;
		Boolean isEndOfWord = false;

		public Node(Boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
			children = new HashMap<>();
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

		public Map<Character, Node> getChildren() {
			return children;
		}

		public Boolean getIsEndOfWord() {
			return isEndOfWord;
		}
	}

	// inserting string in Trie
	public static void insertWord(String inputWord) {
		int counter = 0;
		Node node = parentNode;
		while (counter < inputWord.length()) {
			Character currChar = inputWord.charAt(counter);
			Node currNode = node.getChildren().get(currChar);
			if (currNode == null) {
				if (counter == inputWord.length() - 1)
					currNode = new Node(true);

				else
					currNode = new Node(false);
				node.getChildren().put(currChar, currNode);
			}
			node = currNode;
			counter++;
		}
	}

	// searching prefix in Trie
	public static boolean prefixTrieSearch(String prefix) {
		int counter = 0;
		Node node = parentNode;
		boolean isPresent = true;
		while (counter < prefix.length()) {
			Character currChar = prefix.charAt(counter);
			Node currNode = node.getChildren().get(currChar);
			if (currNode == null) {
				isPresent = false;
				break;
			}
			node = currNode;
			counter++;
		}
		return isPresent;
	}

	// Searching complete String in Trie
	public static boolean CompleteTrieSearch(String searchString) {
		int counter = 0;
		Node node = parentNode;
		boolean isPresent = true;
		while (counter < searchString.length()) {
			Character currChar = searchString.charAt(counter);
			Node currNode = node.getChildren().get(currChar);
			if (currNode == null) {
				isPresent = false;
				break;
			}
			if (counter == searchString.length() - 1 && !currNode.getIsEndOfWord()) {
				isPresent = false;
			}
			node = currNode;
			counter++;
		}
		return isPresent;
	}

	// deleting the given word from Trie
	// first check if the given word is present in Trie and then delete
	// Here we have assumed that word is present in Trie
	public static boolean deleteWordFromTrie(String ipString, int counter, Node currTrieNode) {
		if (counter == ipString.length()  && !currTrieNode.getChildren().isEmpty()) {
			currTrieNode.isEndOfWord = false;
			return false;
		}
		if (counter == ipString.length()  && currTrieNode.getChildren().isEmpty()) {
			return true;
		}
		boolean isDeleteEligible = deleteWordFromTrie(ipString, counter + 1,
				currTrieNode.getChildren().get(ipString.charAt(counter)));
		if (isDeleteEligible) {
			currTrieNode.getChildren().remove(ipString.charAt(counter));
		}
		return currTrieNode.getChildren().isEmpty();
	}

	public static void main(String[] args) {
		insertWord("abc");
		insertWord("abgl");
		insertWord("cdf");
		insertWord("abcd");
		insertWord("lmn");
		System.out.println(CompleteTrieSearch("abgl"));
		System.out.println(CompleteTrieSearch("lmn"));
		System.out.println(CompleteTrieSearch("ckp"));
		System.out.println(CompleteTrieSearch("abkl"));
		System.out.println(CompleteTrieSearch("abcd"));
		System.out.println("ab :" + prefixTrieSearch("ab"));
		System.out.println("cp :" + prefixTrieSearch("cp"));

		deleteWordFromTrie("abc", 0, parentNode);
		deleteWordFromTrie("abgl", 0, parentNode);
		System.out.println("deleted abc");
	}
}
