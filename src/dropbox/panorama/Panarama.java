package dropbox.panorama;

/*
问题是如果NASA提出要设计一个来保存图片的系统(比如就叫Panorama)。问你如何设计出可以支持update , fetch.
粗体是给出的template, 细体是我的给的answer (和面试官聊了下想法他说可以开始做)
每个sector对应的保存一个图片。 他说想一下如果图片很大 不能直接保存该怎么办，我说就用image的路径，然后保存路径
他说可以，那如何Create image的路径，我说可以用size作为file name, 他说可以但如果有同样size的file怎么办，
我说那就假设一个hash funcition (generate unique string)，他说可以。然后就开始写。
因为时间不够还要问问题 他就说如果之后要找出stalest image该怎么改?  但没时间讨论了 地里有很多讨论用LRU.




NASA selects Dropbox as its official partner, and we’re tasked with managing
a panorama for the universe. The Hubble telescope (or some other voyager we
have out there) will occasionally snap a photo of a sector of the universe,
and transmit it to us. You are to help write a data structure to manage this.
For the purpose of this problem, assume that the observable universe has been
divided into 2D sectors. Sectors are indexed by x- and y-coordinates.
 */

// byte: The byte data type is an 8-bit signed two's complement integer.
// It has a minimum value of -128 and a maximum value of 127.


import java.util.HashMap;
import java.util.Map;

class File {
    public File(String path) {}
    public Boolean exists() {
        return true;
    }
    public byte[] read() {
//        byte[] bytes = {0, 1, 2};
        return new byte[4];
    }
    public void write(byte[] bytes) {}
}

class Image {
    String path;
    byte[] bytes;
    public Image(byte[] bytes, String path) {
        this.bytes = bytes;
        this.path = path;
    }

    byte[] getBytes() {
        return new byte[4];
    } // no more than 1MB in size
}


/**
 * row-major indexing to be consistent.
 */
class SpacePanorama {
    int rows;
    int cols;
    int capacity;
    Map<Integer, Sector> map;
    DLinkedList list;
    /**
     * initializes the data structure. rows x cols is the sector layout.
     * width, height can be as large as 1K each.
     */
    public SpacePanorama(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        capacity = rows * cols;
        map = new HashMap<>();
        list = new DLinkedList();
    }

    /**
     * The Hubble will occasionally call this (via some radio wave communication)
     * to report new imagery for the sector at (y, x)
     * Images can be up to 1MB in size.
     */
    public void update(int y, int x, Image image) {
        int hash = Integer.hashCode(x + y);
        if (!map.containsKey(hash)) {
            Sector sector = new Sector(x, y, image);
            map.put(hash, sector);
            list.insertHead(sector);
        } else {
            Sector sector = map.get(hash);
            sector.update(image);
            list.visit(sector);
        }

    }

    /**
     * NASA will occasionally call this to check the view of a particular sector.
     */
    public Image fetch(int y, int x) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return null;
        }
        Sector sector = map.get(Integer.hashCode(x + y));
        if (sector != null) {
            list.visit(sector);
            return sector.getImage();
        }
        return null;

    }

    /**
     * return the 2D index of the sector that has the stalest data.
     * the idea is that this may help the telescope decide where to aim next.
     */
    public Sector getStalestSector() {
        return list.removeLast();
    }
}
