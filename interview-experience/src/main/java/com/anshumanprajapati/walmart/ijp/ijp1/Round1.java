package com.anshumanprajapati.walmart.ijp.ijp1;

import java.util.HashMap;
import java.util.*;



public class Round1{
    public static void main(String[] args) {}
}

class Question1 {

    static class Pair{
        char c;
        int occ;

        public Pair(char c, int occ){
            this.c = c;
            this.occ = occ;
        }
    }

    public static void main(String[] args) {
        // question 1
        // tree
        // eetr

        //cccaaa
        //cccaaa


        // freq [a -> 3
        // c -> 3
        // ] * 26

        // o(n) n - size string
        // building string time compl - 26 * 26
        // map/freq array -> 26

        // aabbcderttktaa

	    /*
	        {
	            b - 2
	            c - 1
	            d - 1
	            e - 1
	            k - 1
	            r - 1
	        }
	        // (a, 4), (t,3), b(2,1), .......

	        string = a*4 t*3 b*2


	    */
        String ans = printFrequecyWithChar("tree");
        System.out.println(ans);

    }

    public static String printFrequecyWithChar(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0) +1 );  // 26

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x,y) -> y.occ - x.occ); // 26

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()) );
        }


        StringBuilder res = new StringBuilder(); // (original string size)
        while(!maxHeap.isEmpty()){
            Pair top = maxHeap.poll();
            int occ = top.occ;

            while(occ-- >0){
                res.append(top.c);
            }
        }

        // O(n) + 26 log 26 + O(n) => O(n) (n is size of string);

        return res.toString();

    }
}

class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode common;
    public static void main(String[] args) {

        //Question 2
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        findCommonAn(root, 1, 2);

        if(common==null){
            System.out.println("Nothing found in common");
        }else{
            System.out.println(common.val);
        }
    }


    public static boolean findCommonAn(TreeNode root, int node1, int node2){
        if(root==null) return false;

        if(root.left==null && root.right==null && root.val!=node1 && root.val!=node2) return false;

        boolean left = findCommonAn(root.left, node1, node2);
        boolean right = findCommonAn(root.right, node1, node2);

        if(left && right) {
            if(common==null){
                common = root;
            }
        }else if( (left || right) && (root.val == node1 || root.val == node2)){
            if(common==null){
                common = root;
            }
        }
        if(root.val == node1 || root.val == node2) return true;

        return left || right;
    }
}
