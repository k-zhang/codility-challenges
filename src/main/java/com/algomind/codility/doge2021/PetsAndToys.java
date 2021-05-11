package com.algomind.codility.doge2021;

import java.util.*;

public class PetsAndToys {
    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        int relationshipLength = A.length;

        int[] nonGrouped = new int[P.length];
        int[] groupIndices = new int[P.length];
        List<Set<Integer>> groupList = new ArrayList<>();
        groupList.add(Set.of());

        for(int i = 0 ; i < relationshipLength ; i ++) {
            int p1 = A[i];
            int p2 = B[i];

            if (groupIndices[p1] == 0 && groupIndices[p2] == 0) {
                Set<Integer> newGroup = new HashSet<>();
                newGroup.add(p1);
                newGroup.add(p2);

                groupList.add(newGroup);
                groupIndices[p1] = groupList.size() - 1;
                groupIndices[p2] = groupList.size() - 1;

                nonGrouped[p1] = 1;
                nonGrouped[p2] = 1;
            } else if (groupIndices[p1] != 0 && groupIndices[p2] == 0 ) {
                int groupP1Index = groupIndices[p1];
                Set<Integer> groupP1 = groupList.get(groupP1Index);
                groupP1.add(p2);
                groupIndices[p2] = groupP1Index;
                nonGrouped[p2] = 1;
            } else if (groupIndices[p1] == 0 && groupIndices[p2] != 0 ) {
                int groupP2Index = groupIndices[p2];
                Set<Integer> groupP2 = groupList.get(groupP2Index);
                groupP2.add(p1);
                groupIndices[p1] = groupP2Index;
                nonGrouped[p1] = 1;
            } else {
                int groupP1Index = groupIndices[p1];
                int groupP2Index = groupIndices[p2];

                if(groupP1Index != groupP2Index) {
                    Set<Integer> groupP1 = groupList.get(groupP1Index);
                    Set<Integer> groupP2 = groupList.get(groupP2Index);
                    groupP1.addAll(groupP2);
                    for(Integer index : groupP2) {
                        groupIndices[index] = groupP1Index;
                    }
                }
            }
        }

        int[] groups = Arrays.stream(groupIndices).distinct().toArray();

        // Check
        for(int groupIndex : groups) {
            Set<Integer> group = groupList.get(groupIndex);

            int dogCount = 0;
            int dogToyCount = 0;

            for(Integer person : group) {
                if(P[person] == 1) dogCount ++;
                if(T[person] == 1) dogToyCount ++;
            }

            if(dogCount != dogToyCount) return false;
        }

        for(int person = 0; person < nonGrouped.length; person++) {
            if(nonGrouped[person] == 0 && P[person] != T[person]) return false;
        }

        return true;
    }
}
