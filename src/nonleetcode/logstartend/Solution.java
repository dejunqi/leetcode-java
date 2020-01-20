package nonleetcode.logstartend;

import nonleetcode.logstartend.version1.Logger;

public class Solution {

    public void test() {
        Logger lg = new Logger();
        lg.started("1", 100);
        lg.started("2", 101);
        lg.finished("2", 102);
        lg.started("3", 103);
        lg.finished("1", 104);
        lg.finished("3", 105);
    }
}
