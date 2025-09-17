package com.anshumanprajapati.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopologicalSort {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        ArrayList<Integer> topologicalSort = new ArrayList<>();


        // BFS (Indegree)
        int[] indegree = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);

        for(int i=0; i<n; i++){
            for( int v: adj.get(i) ){
                indegree[v]++;
            }
        }

        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int first = pq.poll();
            topologicalSort.add(first);

            for(int v: adj.get(first)){
                indegree[v]--;

                if(indegree[v]==0){
                    pq.offer(v);
                }
            }
        }

        return topologicalSort;
    }



    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        ArrayList<Integer> topologicalSort = new ArrayList<>();

        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {
            if (visited[i]!=1)
                topologicalSortUtil(i, adj, visited, stack);
        }

        while (!stack.empty()) {
            topologicalSort.add(stack.pop());
        }

        return topologicalSort;

    }


    static void topologicalSortUtil(int v, ArrayList<ArrayList<Integer>>adj, int[] visited, Stack<Integer> stack){
        visited[v] = 1;

        for (int i : adj.get(v)) {
            if (visited[i]!=1)
                topologicalSortUtil(i, adj, visited, stack);
        }


        stack.push(v);
    }
}
