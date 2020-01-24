package dropbox.bittorrent;

public class Chunk {
    public int start;
    public int end;
    public Chunk(int e) {
        start = 0;
        end = e;
    }
}
