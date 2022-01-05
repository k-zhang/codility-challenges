package com.algomind.codility.nationalcodingweek;

public class NationalCodingWeek {
    public String solution(String S) {
        if (S.length() < 3) return S;
        var chars = S.toCharArray();

        int i = 0;
        while (i + 2 < S.length()) {
            if (chars[i] == 'a' && chars[i + 1] == 'b' && chars[i + 2] == 'b') {
                chars[i] = 'b';
                chars[i + 1] = 'a';
                chars[i + 2] = 'a';
                i = Math.max(i - 2, 0);
            }else{
                i++;
            }
        }

        return new String(chars);
    }

    public String solution1(String S) {
        if (S.length() < 3) return S;

        var chars = S.toCharArray();
        var finished = false;

        while (!finished) {
            finished = true;
            int i = 0;
            while (i + 2 < S.length()) {
                if (chars[i] == 'a' && chars[i + 1] == 'b' && chars[i + 2] == 'b') {
                    chars[i] = 'b';
                    chars[i + 1] = 'a';
                    chars[i + 2] = 'a';
                    finished = false;
                    i += 2;
                } else {
                    i++;
                }
            }
        }

        return new String(chars);
    }
}
