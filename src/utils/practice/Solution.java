package utils.practice;


import java.util.*;

import utils.TreeNode;

/*
put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3],
because you need to return all logs within 2016 and 2017.

retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2],
because you need to return all logs start

from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
*/
public class Solution {

    public void test() {
        LogSystem log = new LogSystem();
        log.put(1,"2017:01:01:23:59:59");
        log.put(2,"2017:01:01:22:59:59");
        log.put(3,"2016:01:01:00:00:00");
        List<Integer> res1 = log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        for (Integer v : res1) {
            System.out.println(v);
        }
    }
}