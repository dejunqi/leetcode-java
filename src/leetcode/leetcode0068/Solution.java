package leetcode.leetcode0068;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        int curLen = 0;
        while (right < words.length) {
            if (curLen + right - left + words[right].length() > maxWidth ) {
                res.add(packLine(words, left, right - 1, curLen, maxWidth, false));
                left = right;
                curLen = 0;
            }
            curLen += words[right].length();
            right++;
        }
        res.add(packLine(words, left, right - 1, curLen, maxWidth, true));
        return res;
    }

    private String packLine(String[] words, int l, int r, int curLen, int maxWidth, boolean isLastLine) {
        int totalEmptySpace = maxWidth - curLen;
        int numWords = r - l + 1;
        StringBuilder sb = new StringBuilder();
        if (isLastLine || numWords == 1) {
            while (l < r) {
                sb.append(words[l]);
                sb.append(' ');
                l++;
            }
            sb.append(words[r]);
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
        } else {
            int space = totalEmptySpace / (numWords - 1);
            int extraSpace = totalEmptySpace % (numWords - 1);
            for (int i = l; i <= r; i++) {
                sb.append(words[i]);
                if (i < r) {
                    sb.append(new String(new char[space]).replace('\0', ' '));
                    if (extraSpace > 0) {
                        sb.append(' ');
                        extraSpace--;
                    }
                }
            }
        }
        return sb.toString();
    }



    public void test() {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What","must","be","acknowledgment","shall","be"};
//        String[] words = {
//                "Science","is","what","we","understand",
//                "well","enough","to","explain","to","a",
//                "computer.","Art","is","everything",
//                "else","we","do"
//        };
//        String[] words = {
//                "ask","not","what","your","country",
//                "can","do","for","you","ask","what",
//                "you","can","do","for","your","country"
//        };
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        List<String> res = fullJustify(words, 6);
        for (String s : res) {
            System.out.println(s);
            System.out.println(s.length());
        }
    }


}
