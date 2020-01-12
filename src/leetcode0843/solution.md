Intuition solution
```$xslt
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

```
That is, we guess a word (randomly picked) and get back the number of match `N`. Then we eliminate all other words
which dose not match the secret with `N`, then repeat the process. Doing this will shrink the sample every time. As
the code above, this process has about 80% chance to pass the test, but not gurantee, can we improve the chance of
success ?

Here is the solution:

Normally, we have a chance of getting 0 match when calling `master.guess`. As a result, the size of sample (wordlist)
reduce slowly. We are going to assume that, we will always run into the worse case, we need to **guess a word that can
minimum our worse outcome**.

We compare each two words and count their match. 
首先，选择哪个与整个集合平均相似度最高的那个单词作为candidate, 这里把平均相似度定义为该单词和其余所有单词匹配值大于零的数目。因为与整个集合平均相似度最高的
单词是把该单词与其余所有单词相匹配得到值为0的次数最少的那个单词。