package dropbox.panorama;

import java.util.HashMap;
import java.util.Map;

/**
 * row-major indexing to be consistent.
 */
public class SpacePanorama {
    int rows;
    int cols;
    Map<Integer, Sector> map;
    /**
     * initializes the data structure. rows x cols is the sector layout.
     * width, height can be as large as 1K each.
     */
    public SpacePanorama(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        map = new HashMap<>();
    }

    /**
     * The Hubble will occasionally call this (via some radio wave communication)
     * to report new imagery for the sector at (y, x)
     * Images can be up to 1MB in size.
     */
    public void update(int y, int x, Image image) {
        int key = Integer.hashCode(x + y);
        if (map.containsKey(key)) {
            map.get(key).update(image);
        }
    }

    /**
     * NASA will occasionally call this to check the view of a particular sector.
     */
    public Image fetch(int y, int x) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return null;
        }
        int key = Integer.hashCode(x + y);
        return map.get(key).getImage();
    }

    /**
     * return the 2D index of the sector that has the stalest data.
     * the idea is that this may help the telescope decide where to aim next.
     */
    public Sector getStalestSector() {
        return null;
    }
}
