package com.algomind.codility.doge2021;

import java.util.*;

// Accepted answer
public class PetsAndToys {
    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        int N = P.length;

        List<Integer>[] relationships = new ArrayList[N];

        for(int i = 0 ; i < A.length ; i ++) {
            int a = A[i], b = B[i];
            addRelationshipBetween(relationships, a, b);
            addRelationshipBetween(relationships, b, a);
        }

        boolean[] visited = new boolean[N];

        for( int i = 0 ; i < N ; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                int s = 0;
                int dogCount = 0, dogToyCount = 0;
                while(!stack.isEmpty()) {
                    int v = stack.pop();
                    if(P[v] == 1) dogCount ++;
                    if(T[v] == 1) dogToyCount ++;

                    List<Integer> reachablePersonFromV = relationships[v];

                    if(reachablePersonFromV != null) {
                        for (int person : reachablePersonFromV) {
                            if (!visited[person]) {
                                visited[person] = true;
                                stack.push(person);
                            }
                        }
                    }
                }

                if(dogCount != dogToyCount) return false;
            }
        }

        return true;
    }

    private void addRelationshipBetween(List<Integer>[] edges, int a, int b) {
        List<Integer> adjOfA = edges[a];
        if (adjOfA == null) {
            adjOfA = new ArrayList<>();
            edges[a] = adjOfA;
        }
        adjOfA.add(b);
    }
}
