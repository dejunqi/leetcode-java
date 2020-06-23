package leetcode.leetcode0127;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        wordSet.add(beginWord);
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            step += 1;
            for (int i = 0; i < len; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                queue.offer(newWord);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void test() {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String > wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
//        String beginWord = "leet";
//        String endWord = "code";
//        List<String > wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dog"));
        List<TestItem> testCase = new ArrayList<>();

        testCase.add(new TestItem(
                "hit",
                "cog",
                new String[] {"hot","dot","dog","lot","log","cog"}
        ));


        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
