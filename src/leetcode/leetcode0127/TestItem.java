package leetcode.leetcode0127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestItem {
    private String beginWord;
    private String endWord;
    List<String> wordList;

    public TestItem(String beginWord, String endWord, String[] wordList) {
        this.beginWord = endWord;
        this.endWord = endWord;
        this.wordList = new ArrayList<>(Arrays.asList(wordList));
    }
}
