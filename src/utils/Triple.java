package utils;

public class Triple<T, U, V> {
    T t;
    U u;
    V v;
    public Triple(T t, U u, V v) {
        this.t = t;
        this.u = u;
        this.v = v;
    }

    public T getT() {
        return t;
    }

    public U getU() {
        return u;
    }

    public V getV() {
        return v;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setU(U u) {
        this.u = u;
    }

    public void setV(V v) {
        this.v = v;
    }
}
