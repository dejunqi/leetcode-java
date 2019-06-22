package leetcode0635;
import java.util.ArrayList;
import java.util.List;

public class LogSystem {

    private class Entry {
        int id;
        TimeStamp timeStampObject;
        Entry(int id, TimeStamp timeStampObject) {
            this.id = id;
            this.timeStampObject = timeStampObject;
        }
    }

    private List<Entry> list;
    public LogSystem() {
        list = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        list.add(new Entry(id, new TimeStamp(timestamp)));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        TimeStamp ts = new TimeStamp(s);
        TimeStamp te = new TimeStamp(e);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Entry entry = list.get(i);
            TimeStamp tp = entry.timeStampObject;
            if (tp.compareTo(ts, gra) >= 0 && tp.compareTo(te, gra) <= 0) {
                res.add(entry.id);
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