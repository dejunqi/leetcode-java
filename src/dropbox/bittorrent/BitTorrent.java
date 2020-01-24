package dropbox.bittorrent;

import java.util.Collections;
import java.util.List;

public class BitTorrent {

    public boolean isFileDone(List<Chunk> chunks, int size) {
        if (chunks == null || chunks.size() == 0) return false;

        Collections.sort(chunks, (a, b) -> a.start - b.start);
        if (chunks.get(0).start != 0) {
            return false;
        }

        int end = chunks.get(0).end;

        for (int i = 0; i < chunks.size(); i++) {
            Chunk chunk = chunks.get(i);
            if (chunk.start > end) {
                return false;
            } else {
                end = Math.max(end, chunk.end);
            }
        }

        return end == size;
    }
}
