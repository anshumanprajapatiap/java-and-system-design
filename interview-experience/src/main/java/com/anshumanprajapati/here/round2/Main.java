package com.anshumanprajapati.here.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		List<Character> itr = Arrays.asList('a', 'b', 'a', 'f', 'z', 'a', 'f');
		Map<Character, Integer> freqMap = new HashMap<>();
		
//		findFreq(itr, freqMap);
//		printFreq(freqMap);
		String s = "abcdfeaaafbc";
//		abc(s);
		char[] listofChar = s.toCharArray();
	
		System.out.println(itr);
	}
	
	public static void findFreq(List<Character> itr, Map<Character, Integer> freqMap) {
		
		for(Character c: itr) {
			freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
		}
		
	}
	
	public static void printFreq( Map<Character, Integer> freqMap) {
		
		for(Character c: freqMap.keySet()) {
			System.out.println(c + " : "+freqMap.get(c));
		}
			
	}
//	String s = "abcdfeaaafbc";
	
	public static void abc(String s) {
		int[] arr = new int[26];
		int[] a2= new int[] {0 , 0};
		
		for(char c: s.toCharArray()) {
			arr[c-'a']++;
		}
		
//		for(int i=0; i<s.length(); i++) {
//			char c = s.charAt(i);
//			// 0  1  2   3  4  5  6  7.... 25
//			// 4  2  2   1  1  2  0  0     0
//			// a  b  c   d  e  f  g  h..... z
//			// 97 98 99 ................... 97+25
//			/*
//			 * 
//			 *  a : 4
//				b : 2
//				c : 2
//				d : 1
//				e : 1
//				f : 2
//			 */
//	
//			arr[c-'a']++;
//		}
		
		for(int i=0; i<26; i++) {
			char c = (char)('a'+i);
			
			System.out.println(c+ " : "+ arr[i]);
		}
	}
	
	

}
