package com.anshumanprajapati.recro;

public class Screening {

    public static void main(String[] args) {
        String input = "0(ab)(c1d)9(,)6ab";
        System.out.println( process(input) );
    }
    public static  int parseIntValue(String s){
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            int op = 0;
            boolean flag = false;
            for(char c: s.toCharArray()){
                if(c>='0' && c<='9') {
                    op += c - '0';
                }
            }
        }
        return 0;
    }


    public static String process(String input){
        String[] inputArray = input.split("\\(");
        int n = inputArray.length;
        StringBuilder res = new StringBuilder();

        int op = parseIntValue(inputArray[0]);


        for(int idx=1; idx<n;  idx++){
            String[] s  = inputArray[idx].split("\\)");
            if(s.length==0) continue;

            while(op-- >0){
                res.append(s[0]);
            }
            if(s.length==2)
                op =  Integer.parseInt(s[1]);
            else
                op = 0;
        }
        return res.toString();
    }
}
