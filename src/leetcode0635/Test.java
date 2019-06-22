package leetcode0635;

import java.util.List;

public class Test {

    public void test() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        List<Integer> l1 = logSystem.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        List<Integer> l2 = logSystem.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");

        System.out.println(l1);
        System.out.println(l2);
    }
}
