package leetcode0843;

public class Master {
    public int guess(String word, String screate) {
        int matches = 0;
        for (int i = 0; i < word.length(); ++i) if (word.charAt(i) == screate.charAt(i)) matches ++;
        return matches;
    }
}
