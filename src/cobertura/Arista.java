package cobertura;

class Arista {
    
    int u;
    int v;
    
    public Arista(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "{"+u+","+v+"}";
    }
}
