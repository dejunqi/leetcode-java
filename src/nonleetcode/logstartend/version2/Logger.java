package nonleetcode.logstartend.version2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Logger {
    private class Node {
        long start;
        long end;
        String id;
        Node(String id, long time) {
            start = time;
            end = -1;
            this.id = id;
        }
    }

    private TreeMap<Long, Node> ends;
    private Map<String, Node> starts;

    Logger() {
        ends = new TreeMap<>();
        starts = new HashMap<>();
    }

    public void put(long time, String id) {
        if (!starts.containsKey(id)) {
            starts.put(id, new Node(id, time));
        }
    }

    public void finished(long time, String id) {
        if (!starts.containsKey(id)) {
            return;
        }

        Node node = starts.get(id);
        node.end = time;
        starts.remove(id);
        ends.put(time, node);
    }

    public void print() {
        for (Long time : ends.keySet()) {
            Node node = ends.get(time);
            System.out.println(node.id + " start at " + node.start + " end at " + node.end);
        }
    }


}
