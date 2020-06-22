package leetcode0535;

public class Solution {

    public void test() {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        String shortUrl = codec.encode(longUrl);
        System.out.println(codec.decode(shortUrl));
    }
}
