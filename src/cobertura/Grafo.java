package cobertura;
import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    ArrayList<Arista> A;

    public Grafo(ArrayList A) {
        this.A = A;
    }
    
    public Grafo(Arista[] aristas) {
        this.A = new ArrayList<Arista>(Arrays.asList(aristas));
    }

    public ArrayList<Arista> getA() {
        return A;
    }
    
}
