package leetcode0843;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;


public class Solution {


    public void findSecretWordv0(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess, "hbaczn");

            List<String> list = new ArrayList<>();
            for (String w : wordlist) {
                if (match(guess, w) == x) {
                    list.add(w);
                }
            }
            wordlist = list.toArray(new String[list.size()]);
            System.out.println(wordlist.length);
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            Pair minimax = new Pair("", 1000);
            for (String w : wordlist) {
                int num = count.getOrDefault(w, 0);
                if (num < minimax.getValue()) {
                    minimax = new Pair(w, num);
                }
            }

            minimax.print();
            x = master.guess(minimax.getKey(), "acckzz");
            List<String> wordlist2 = new ArrayList<String>();

            for (String w : wordlist) {
                if (match(minimax.getKey(), w) == x) {
                    wordlist2.add(w);
                }
            }

            wordlist = wordlist2.toArray(new String[0]);
//            System.out.println(wordlist);
        }
    }

    private int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i) if (a.charAt(i) == b.charAt(i)) matches ++;
        return matches;
    }


    public void test() {
        String secrete = "hbaczn";
        String[] wordlist = {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa",
                "qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw",
                "evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx",
                "bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve",
                "rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp",
                "vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy",
                "loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr",
                "lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz",
                "hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs",
                "oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho",
                "alrplq","brklfk"};

//        String[] wordlist = {"acckzz", "rbejfk", "ccbazz", "eiowzz", "abcczz"};
        Master master = new Master();
        findSecretWord(wordlist, master);
    }
}
