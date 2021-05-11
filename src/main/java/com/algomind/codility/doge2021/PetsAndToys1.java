package com.algomind.codility.doge2021;

import java.util.*;

// 100% Correct but performance not accepted
public class PetsAndToys1 {
    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        int relationshipLength = A.length;

        int[] nonGrouped = new int[P.length];
        Map<Integer, Set<Integer>> personToGroupMap = new HashMap<>();

        for(int i = 0 ; i < relationshipLength ; i ++) {
            int p1 = A[i];
            int p2 = B[i];

            if(!personToGroupMap.containsKey(p1) && !personToGroupMap.containsKey(p2)) {
                Set<Integer> newGroup = new HashSet<>();
                newGroup.add(p1);
                newGroup.add(p2);
                personToGroupMap.put(p1, newGroup);
                personToGroupMap.put(p2, newGroup);
                nonGrouped[p1] = 1;
                nonGrouped[p2] = 1;
            }else if(personToGroupMap.containsKey(p1) && !personToGroupMap.containsKey(p2)) {
                Set<Integer> p1Group = personToGroupMap.get(p1);
                p1Group.add(p2);
                personToGroupMap.put(p2, p1Group);
                nonGrouped[p2] = 1;
            }else if(!personToGroupMap.containsKey(p1) && personToGroupMap.containsKey(p2)) {
                Set<Integer> p2Group = personToGroupMap.get(p2);
                p2Group.add(p1);
                personToGroupMap.put(p1, p2Group);
                nonGrouped[p1] = 1;
            }else {
                Set<Integer> p1Group = personToGroupMap.get(p1);
                Set<Integer> p2Group = personToGroupMap.get(p2);

                if(p1Group != p2Group) {
                    p1Group.addAll(p2Group);
                    for (Integer person : p2Group) {
                        personToGroupMap.put(person, p1Group);
                    }
                }
            }
        }

        Set<Set<Integer>> groups = new HashSet<>();
        for(Set<Integer> group : personToGroupMap.values()) {
            if(groups.contains(group)) continue;

            int dogCount = 0;
            int dogToyCount = 0;

            for(Integer person : group) {
                if(P[person] == 1) dogCount ++;
                if(T[person] == 1) dogToyCount ++;
            }

            if(dogCount != dogToyCount) return false;

            groups.add(group);
        }

        for(int person = 0; person < nonGrouped.length; person++) {
            if(nonGrouped[person] == 0 && P[person] != T[person]) return false;
        }

        return true;
    }
}
