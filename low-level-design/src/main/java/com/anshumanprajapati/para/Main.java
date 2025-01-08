package para;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		ArrayList<String> ans = new ArrayList<>();
		String st = "";
		getAllValidPara(n, n, ans, st);
		System.out.println(ans);

	}
	
	static void getAllValidPara(int open, int close, ArrayList<String> ans, String temp) {
		
		
		if(open==0 && close==0) {
			ans.add(temp.toString());
			return;
		}
		if(open !=0) {
			String op1 = temp+"(";
			getAllValidPara(open-1, close, ans, op1);
		}
		
		if(open<close) {
			String op2 = temp+")";
			getAllValidPara(open, close-1, ans, op2);
		}
	}
	
	

}
