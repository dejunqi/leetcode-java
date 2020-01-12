package leetcode0843;

import java.util.*;

public class Solution {
    public void findSecretWord(String[] wordlist, Master master) {

        int idx = 0;
        int cnt = 0;
        Random rnd = new Random();
        while (idx < 10 && cnt < 6) {
            String word = wordlist[rnd.nextInt(wordlist.length)];
            cnt = master.guess(word);
            ArrayList<String> list = new ArrayList<>();
            for (String w : wordlist) {
                if (match(word, w) == cnt) {
                    list.add(w);
                }
            }
            wordlist = list.toArray(new String[0]);
            idx++;
        }
    }

    public void findSecretWord2(String[] wordlist, Master master) {
        int idx = 0;
        int cnt = 0;
        while (idx < 10 && cnt < 6) {
            Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            String candidate = "";
            int num = 1000;
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < num) {
                    candidate = w;
                    num = count.getOrDefault(w, 0);
                }
            }

            cnt = master.guess(candidate);
            List<String> list = new ArrayList<>();
            for (String w : wordlist) {
                if (match(candidate, w) == cnt) {
                    list.add(w);
                }
            }
            wordlist = list.toArray(new String[0]);
            idx += 1;
        }

    }


    private int match(String s1, String s2) {
        int len = s1.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                res += 1;
            }
        }
        return res;
    }
}
