package dropbox.fileaccess;

import java.util.*;

public class Solution {

    public boolean hasAccess(String targetFolder, String[][] folders, Set<String> accessible) {
        if (accessible.contains(targetFolder)) {
            return true;
        }
        Map<String, String> map = new HashMap<>();
        for (String[] item : folders) {
            map.put(item[0], item[1]);
        }
        String cur = targetFolder;
        while (!cur.equals("")) {
            if (accessible.contains(cur)) {
                return true;
            }
            cur = map.get(cur);
        }

        return false;
    }



    public void test() {
        String[][] folders = {{"A", ""}, {"B", "A"}, {"C", "B"}, {"D", "B"}, {"E", "A"}, {"F", "E"}};
        Set<String> accessible = new HashSet<>(Arrays.asList("C", "E"));
        System.out.println(hasAccess("C", folders, accessible));
    }
}
