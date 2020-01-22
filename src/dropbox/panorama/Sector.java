package dropbox.panorama;

public class Sector {
    private int x;
    private int y;
    private Image image;
    int key;
    Sector prev;
    Sector next;
    public Sector(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.key = Integer.hashCode(this.x + this.y);
        this.image = image;
        prev = null;
        next = null;
    }
    int getX() {return this.x;}
    int getY() {return this.y;}

    public boolean equals(Sector other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    public void update(Image newImag) {
        this.image = newImag;
    }

    public Image getImage() {
        return this.image;
    }
}
