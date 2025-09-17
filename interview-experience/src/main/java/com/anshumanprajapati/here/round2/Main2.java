package com.anshumanprajapati.here.round2;
import java.util.HashMap;
import java.util.Map;

// QUESTION ONE TO FIND OUT DUPLICATE ELEMENT ON ARRAY
// CREATE A LINKEDLIST AND ITS OPERATION



public class Main2 {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		// Array <- 1,2,3,4
		
		char[] listOfNumber = new char[] {};
		
		// String DUPLICATE, NOT DUPLICATE
		MyLinkedList node5 = new MyLinkedList(6, null);
		MyLinkedList node4 = new MyLinkedList(5, node5);
		MyLinkedList node3 = new MyLinkedList(3, node4);
		MyLinkedList node2 = new MyLinkedList(2, node3);
		MyLinkedList node1 = new MyLinkedList(1, node2);
		
		MyLinkedList node = node1;
		
		
		node.insertValue(4, node3, node4);
		
		while(node!=null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		
		
		
		

	}
	
	


}




class MyLinkedList{
	
	public int value;
	public MyLinkedList next;
	
	
	MyLinkedList(int val, MyLinkedList nextAddress){
		this.value = val;
		this.next = nextAddress;
	}
	
	// 1 -> 2-> 3-> 5-> 6->null
	// 3 -> 4 -> 5 
	
	public void insertValue(int val, MyLinkedList prev, MyLinkedList next) {
		MyLinkedList current = new MyLinkedList(val, next);
		prev.next = current;
	}
}


