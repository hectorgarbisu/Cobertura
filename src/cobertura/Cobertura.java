package cobertura;

import java.util.ArrayList;

public class Cobertura {
    
    public static ArrayList ACO(Grafo grafo){
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

    private static ArrayList eliminarIncidentes(ArrayList E, Arista arista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
