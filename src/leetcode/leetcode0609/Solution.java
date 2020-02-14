package leetcode0609;

import java.util.*;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String filepath = strs[0] + "/" + strs[i].substring(0, idx);
                map.put(content, map.getOrDefault(content, new ArrayList<>()));
                map.get(content).add(filepath);
            }
        }

        for (String content : map.keySet()) {
            List<String> list = map.get(content);
            if (list.size() > 1) {
                res.add(list);
            }
        }

        return res;
    }

    public void test() {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        findDuplicate(paths);
    }


}
