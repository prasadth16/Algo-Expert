package com.category.simple.twonumbersum;

public class DoublyCireculerLinkedListTest {
	public static void main(String[] args) {

		System.out.println("Creating a new list....");
		DoublyCirculerLinkedList<Integer> myList = new DoublyCirculerLinkedList<>();
		System.out.println("Adding few elements to the new list....");
		myList.addNode(17);
		myList.addNode(18);
		myList.addNode(19);
		myList.addNode(20);
		myList.addNode(21);
		myList.addNode(22);
		System.out.println("Printing the list...");
		myList.traverseList();
		System.out.println("Printing the list in reverse order...");
		myList.traverseReverse();
		System.out.println("checking the presense of an element in the list..."+myList.contains(19));
		System.out.println("removing element from the list...");
		System.out.println(myList.removeNode(22));
		System.out.println("Printing the list...");
		myList.traverseList();
		System.out.println("Printing the list in reverse order...");
		myList.traverseReverse();
	}

}
