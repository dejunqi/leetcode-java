package nonleetcode.logstartend.version1;

import java.util.HashMap;
import java.util.Map;

/*
实 现 start(id, ts), end(id, ts), 按 start time 顺 序 打 印 log
有 ⼀ 个 Class 叫 Logger ， 它 有 两 个 函 数 ， ⼀ 个 是 LogStart(int logId, int timestamp) ， ⼀ 个 是
LogFinish(int logId, int timestamp) 。 Log 开 始 时 LogStart 会 被 调 ⽤ ， log 结 束 时 LogFinish 会 被
调 ⽤。 要 求 是 实 现 这 两 个 函 数 ， 并 打 印 已 经 结 束 的 log ， 打 印 log 时 要 按 log 的 开 始 时 间 排
序。
interface Logger {
void started(long timestamp, String requestId);
void finished(long timestamp, String requestId);
}
started(100, "1")
started(101, "2")
finished(102, "2")
started(103, "3")
finished(104, "1")
finished(105, "3")
Expected Output:
$1 start at 100 end at 104
$2 start at 101 end at 102
$3 start at 103 end at 105
*/

public class Logger {
    private class Node {
        String id;
        long start;
        long end;
        Node prev;
        Node next;
        Node(String id, long start) {
            this.id = id;
            this.start = start;
            end = -1;
        }
    }
    Node head, tail;
    Map<String, Node> map;
    public Logger() {
        head = new Node("", -1);
        tail = new Node("", -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void started(String id, long time) {
        Node cur = new Node(id, time);
        map.put(id, cur);
        add(cur);
    }

    private void add(Node cur) {
        if (cur == null) return;
        cur.next = tail;
        cur.prev = tail.prev;
        tail.prev.next = cur;
        tail.prev = cur;
    }

    public void finished(String id, long time) {
        Node cur = map.get(id);
        if (cur != null && cur.end == -1) {
            cur.end = time;
            map.remove(id);
        }
    }
}
