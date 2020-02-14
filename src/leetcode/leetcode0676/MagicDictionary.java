package leetcode0676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
    private Map<String, List<int[]>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            for (int i = 0; i < str.length(); i++) {
                String key = str.substring(0, i) + str.substring(i + 1);
                int[] pair = new int[] {i, str.charAt(i)};
                List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                list.add(pair);
                map.put(key, list);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                List<int[]> list = map.get(key);
                for (int[] pair : list) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}

