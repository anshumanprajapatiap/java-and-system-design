package com.anshumanprajapati.others;

import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] nodes = {
                "World",
                "Asia", "Africa",
                "Nepal", "India",
                "SouthAfrica", "Egypt",
                "Kathmandu", "Janakpur",
                "Delhi", "Mumbai",
                "CapeTown", "Johannesburg",
                "Giza", "Suez",
        };
        int n = nodes.length;
        int m = 2; // Each node has 2 children
        int q = 3; // Number of queries

        String[] queries = {
                "1 Nepal 9",
                "1 India 9",
                "1 India 9",
                "1 Egypt 9",
                "2 Nepal 2",
                "3 Asia 9"};

        JusPay jusPay = new JusPay(n, m, q, nodes, queries);
        jusPay.buildTree();
        jusPay.printPreOrderTree(jusPay.root);

        System.out.println();
//        jusPay.printNodeMap();

        jusPay.runQueries();
    }
}

class TreeNode{
    String data;
    String lockedBy;
    boolean isLocked;
    List<TreeNode> children;
    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
        this.isLocked = false;
    }
}

public class JusPay{
    int n;
    int m;
    int q;
    String[] nodes;
    String[] queries;

    // Root of the tree
    TreeNode root;

    Map<String, TreeNode> nodeMap = new HashMap<>();


    public JusPay(int n, int m, int q, String[] nodes, String[] queries) {
        this.n = n;
        this.m = m;
        this.q = q;
        this.nodes = nodes;
        this.queries = queries;
    }

    public void runQueries() {
        for (String query : queries) {
            String[] parts = query.split(" ");
            int operation = Integer.parseInt(parts[0]);
            String nodeName = parts[1];
            String userId = parts[2];

            if (operation == 1) {
                boolean result = lock(nodeName, userId);
                System.out.println("Lock operation on " + nodeName + " by " + userId + ": " + result);
            } else if (operation == 2) {
                boolean result = unlock(nodeName, userId);
                System.out.println("Unlock operation on " + nodeName + " by " + userId + ": " + result);
            } else if (operation == 3) {
                boolean result = expand(nodeName, userId);
                System.out.println("Expand operation on " + nodeName + " by " + userId + ": " + result);
            }
        }
    }


    public boolean locKUnLockChild(TreeNode node, String userId, boolean isLock) {
        if (node == null) {
            return true;
        }
        boolean canLock = true;
        for (TreeNode child : node.children) {
            if (!child.isLocked) {
                canLock =  locKUnLockChild(child, userId, isLock);
            }else{
                return false;
            }
        }

        node.isLocked = isLock;
        node.lockedBy = isLock ? userId : null;
        return canLock;
    }

    public boolean lock(String nodeName, String userId) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null || node.isLocked || (node.lockedBy != null && !node.lockedBy.equals(userId))) {
            return false;
        }

        return locKUnLockChild(node, userId, true);
    }

    public boolean unlock(String nodeName, String userId) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null || !node.isLocked || !node.lockedBy.equals(userId)) {
            return false;
        }

        return locKUnLockChild(node, userId, false);

    }

    public boolean expand(String nodeName, String userId){
        TreeNode node = nodeMap.get(nodeName);
        if (node == null || node.isLocked) {
            return false;
        }

        boolean flag = true;
        for(TreeNode child: node.children) {
            System.out.println(nodeName + " child: " + child.data + " isLocked: " + child.isLocked + " lockedBy: " + child.lockedBy);
            if(child.isLocked && !child.lockedBy.equals(userId)){
                flag = false;
            }
        }
        return locKUnLockChild(node, userId, true);
    }

    public void buildTree(){
        root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodeMap.put(root.data, root);
        int index = 1;

        while (!queue.isEmpty()){
            TreeNode front =  queue.poll();

            for (int i = 0; i < m && index < n; i++) {
                TreeNode child = new TreeNode(nodes[index++]);
                nodeMap.put(child.data, child);
                front.children.add(child);
                queue.add(child);
            }
        }
    }
    public void printPreOrderTree(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        for (TreeNode child : node.children) {
            printPreOrderTree(child);
        }
    }
    public void printNodeMap() {
        for (Map.Entry<String, TreeNode> entry : nodeMap.entrySet()) {
            System.out.println("Node: " + entry.getKey() + ", Children: " + entry.getValue().children.size());
        }
    }
}