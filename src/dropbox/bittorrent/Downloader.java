package dropbox.bittorrent;

import java.util.PriorityQueue;

public class Downloader {
    private PriorityQueue<Chunk> queue;
    int size;

    public Downloader(int size) {
        this.size = size;
    }
}
