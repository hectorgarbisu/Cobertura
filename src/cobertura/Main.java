package cobertura;

public class Main {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo(new Arista[]{new Arista(1,5),new Arista(2,5),new Arista(2,4),
                                new Arista(2,3),new Arista(1,2),new Arista(4,5)});
    Cobertura.ACO(grafo);
    }
    
}
