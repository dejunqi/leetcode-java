package dropbox.panorama;

public class Sector {
    int r;
    int c;
    int key;
    Image image;
    public Sector(int x, int y, Image img) {
        r = x;
        c = y;
        key = Integer.hashCode(x + y);
        image = img;
    }
    int getX() { return r; }
    int getY() { return c; }

    public void update(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }
}
