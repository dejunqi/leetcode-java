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
        int whiteSpace = maxWidth - curLen;
        int numOfWords = r - l + 1;
        StringBuilder sb = new StringBuilder();
        if (isLastLine || numOfWords == 1) {
            for (int i = l; i <= r; i++) {
                sb.append(words[i]);
                if (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
        } else {
            int space = whiteSpace / (numOfWords - 1);
            int extraSpace = whiteSpace % (numOfWords - 1);
            String spaceString = new String(new char[space]).replace('\0', ' ');
            for (int i = l; i <= r; i++) {
                sb.append(words[i]);
                if (i < r) {
                    sb.append(spaceString);
                    if (extraSpace > 0) {
                        String extraSpaceString = new String(new char[extraSpace]).replace('\0', ' ');
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
