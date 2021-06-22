package com.algomind.codility.thefellowshipofthecode;

import java.util.LinkedList;
import java.util.Queue;

public class TheFellowshipOfTheCode {
    public String solution(String S, int K) {
        var n = S.length();
        var tree = new int[n + 1];
        Queue<Integer>[] p = new LinkedList[26];

        for (int i = 0; i < n; i++) {
            int offset = S.charAt(i) - 'a';
            var queue = p[offset];
            if(queue == null) {
                queue = new LinkedList<>();
            }
            queue.add(i + 1);
            p[offset] = queue;
        }

        StringBuilder r = new StringBuilder();
        for(var i = 1 ; i <= n ; i++) {
            for(var j = 0; j < 26; j++) {
                if(p[j] == null || p[j].isEmpty()) continue;
                var x = p[j].peek();
                var y = x - get(tree, x) - 1;

                if(y <= K) {
                    K -= y;
                    r.append((char)(j + 'a'));
                    add(tree, x);
                    p[j].poll();
                    break;
                }
            }
        }

        return r.toString();
    }

    private int lowest(int x) {
        return x & (-x);
    }

    private int get(int[] b, int m) {
        var ans = 0;
        for(int i = m; i > 0 ; i -= lowest(i)) {
            ans += b[i];
        }
        return ans;
    }

    private void add(int[] b, int x) {
        for(int i = x; i < b.length ; i += lowest(i)) {
            b[i] ++;
        }
    }
}
