package leetcode0635;
import java.util.ArrayList;
import java.util.List;

public class LogSystem {

    private class Log {
        int id;
        TimeStamp timeStamp;
        Log(int id, TimeStamp timeStamp) {
            this.id = id;
            this.timeStamp = timeStamp;
        }
    }

    private List<Log> list;
    public LogSystem() {
        list = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        TimeStamp timeStamp = new TimeStamp(timestamp);
        list.add(new Log(id, timeStamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        TimeStamp start = new TimeStamp(s);
        TimeStamp end = new TimeStamp(e);
        List<Integer> res = new ArrayList<>();
        for (Log log: list) {
            TimeStamp logTime = log.timeStamp;
            if (logTime.compareTo(start, gra) >= 0 && logTime.compareTo(end, gra) <= 0) {
                res.add(log.id);
            }
        }

        return res;
    }

}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */