package com.anshumanprajapati.walmart.ijp.ijp3;
import java.util.*;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Round1 {

    public static void main(String[] args) {

        /*
              1
           /   \
          2     3
           \   / \
            4 5   6
                 /
                7
         */
        // 2 1 3 6
//        -1 0 1
//         2 0  3

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        System.out.println(findTopView(root));

    }

    public static List<Integer> findTopView(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, map);

        int n = map.size();
        int midIndex = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            midIndex = Math.min(midIndex, entry.getKey());
        }
        while(map.size()>0){
            if(map.containsKey(midIndex)){
                ans.add(map.get(midIndex));
                map.remove(midIndex);
            }

            midIndex++;
        }
        return ans;
    }

    public static void dfs(TreeNode node, int idx, Map<Integer, Integer> res){

        if(node== null) return;

        if(!res.containsKey(idx)) res.put(idx, node.val);

        dfs(node.left, idx-1, res);
        dfs(node.right, idx+1, res);
    }
}







// marketing platform
// items
/*

 Item {no}

//Sellers  has items

//top items (seller id)

 */

// seller id -> seller obj

// seller obj -> meta data, List<Items>
// adding items
//  purchase
//  get Top items (dynamic )

// seller  ->

/*
map items (itemid, item)
pq  -> item.purchase is max

2 ->
 a 100
 b  40
 c  80


//  c a

 */

/*

 */

//class CustomCompareItems

class Item{
    String id;
    String name;
    int purchaseTime;
    int availableStock;
}

class Seller{
    String id;
    Map<Integer, Item> map;

    // sellerId  items
    // 1 1
    // 1 2
    // 2 1

    PriorityQueue<Item> minHeap = new PriorityQueue<>();

//    add(){
//
//    }
//
//    purchase(){
//
//    }


}

class Client{
    Map<Integer,  Seller> sellerMap = new HashMap<>();
//
//    addItem(){
//        sellerMap.put("A", new Item());
//    }
}





















