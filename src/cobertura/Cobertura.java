package cobertura;

import java.util.ArrayList;

public class Cobertura {
    
    public static ArrayList coberturaAprox(Grafo grafo){
        ArrayList S = new ArrayList();
        ArrayList E = grafo.getA();
        while(!E.isEmpty()){
            Arista arista = elegirArista(E);
            E = eliminarIncidentes(E,arista);
            S.add(arista.getV());
            S.add(arista.getU());
        }
        return S;
    }
    private static Arista elegirArista(ArrayList<Arista> aristas){
        int r = (int)(Math.random()*(aristas.size()-1));
        return aristas.get(r);
    }

    private static ArrayList eliminarIncidentes(ArrayList<Arista> E, Arista arista) {
        int i = 0;
        while(i < E.size()) {
            if(comparteVertice(E.get(i), arista)){
                E.remove(i);
            }else{
                i++;
            }
        }
        return E;
    }
    
    private static boolean comparteVertice(Arista a, Arista b){
        return (a.getU() == b.getU() || a.getU() == b.getV() || a.getV() == b.getU() || a.getV() == b.getV());
    }
}
