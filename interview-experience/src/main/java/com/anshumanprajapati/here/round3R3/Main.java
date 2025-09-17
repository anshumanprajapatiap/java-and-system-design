package com.anshumanprajapati.here.round3R3;

import java.util.Stack;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String unBalanced = "({[}";
		
		String balanced = ")][(";
		
		String str = "";
		
		System.out.println(checkPara(balanced));
		
	}
	
	
	static boolean checkPara(String str) {
		
		Stack<Character> stack =  new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			
			if(stack.isEmpty()) {
				stack.add(str.charAt(i));
				continue;
			}
			
			if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='(') {
				stack.add(str.charAt(i));
			}else {
				if(str.charAt(i)=='}') {
					Character currentChar = stack.peek();
					if(currentChar=='{') {
						stack.pop();
					}else {
						return false;
					}
					
				}else if(str.charAt(i)==')') {
					Character currentChar = stack.peek();
					if(currentChar=='(') {
						
						stack.pop();
					}else {
						System.out.println(str.charAt(i));
						return false;
					}
					
				} else if(str.charAt(i)==']') {
					Character currentChar = stack.peek();
					if(currentChar=='[') {
						stack.pop();
					}else {
						return false;
					}
					
				}
			}
		}
		
		
		return stack.isEmpty();
		
	}

}
































