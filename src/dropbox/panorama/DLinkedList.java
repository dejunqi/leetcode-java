package dropbox.panorama;

public class DLinkedList {

    int size;
    Sector head;
    Sector tail;
    DLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertHead(Sector sector) {
        sector.next = head;
        if (size == 0) {
            head = sector;
            tail = sector;
        } else {
            head.prev = sector;
            head = sector;
        }
        size++;
    }

    public void visit(Sector sector) {
        if (sector.key == head.key) {
            return;
        }

        if (sector.key == tail.key) {
            Sector prev = sector.prev;
            tail = prev;
            prev.next = null;
            insertHead(sector);
        } else {
            Sector prev = sector.prev;
            Sector post = sector.next;
            prev.next = post;
            post.prev = prev;
            insertHead(sector);
        }
        size--;
    }

    public Sector removeLast() {
        if (size == 0) return null;
        Sector res = null;
        if (size == 1) {
            res = head;
            head = null;
            tail = null;

        } else {
            res = tail;
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return res;
    }
}