package cobertura;

import java.util.ArrayList;

public class Prueba {
    
    public static void pruebas(){
        Grafo[] grafos = {GrafosDePrueba.ejemploDeClase,stringToGraph(GrafosDePrueba.berge),
        stringToGraph(GrafosDePrueba.bondyMurty1),stringToGraph(GrafosDePrueba.bondyMurty2),
        stringToGraph(GrafosDePrueba.bondyMurty3),stringToGraph(GrafosDePrueba.bondyMurty4),
        stringToGraph(GrafosDePrueba.cubo),stringToGraph(GrafosDePrueba.dodecaedro),
        stringToGraph(GrafosDePrueba.folkman),stringToGraph(GrafosDePrueba.grotzsch),
        stringToGraph(GrafosDePrueba.herschel),stringToGraph(GrafosDePrueba.icosaedro),
        stringToGraph(GrafosDePrueba.kuratowski),stringToGraph(GrafosDePrueba.octaedro),
        stringToGraph(GrafosDePrueba.petersen),stringToGraph(GrafosDePrueba.ramsey),
        stringToGraph(GrafosDePrueba.rueda),stringToGraph(GrafosDePrueba.tetraedro),
        stringToGraph(GrafosDePrueba.thomasen),stringToGraph(GrafosDePrueba.tutteCoxeter),};
        int[] coberturaMinimaSizes = {2,40,4,7,7,7,4,12,10,6,5,9,3,4,6,14,5,3,20,15};
        for (int i = 0; i < coberturaMinimaSizes.length; i++) {
            comprobar(grafos[i],coberturaMinimaSizes[i]);
        }

    }
    private static void comprobar(Grafo grafo, int optima){
        String result = "\n - COMPROBANDO GRAFO -\n";
        result += "Aristas del grafo: \n";
        for (Arista arista : grafo.getA()) {
            result += arista +" ";
        }
        ArrayList<Integer> coberturaAprox = Cobertura.coberturaAprox(grafo);
        result += "\nCobertura encontrada: \n";
        for (Integer vertice : coberturaAprox) {
            result += vertice+" ";
        }
        result += "\n¿Es una cobertura?: "+ (escobertura(grafo,coberturaAprox)?"si":"no");
        result += "\nTamaño de la cobertura aproximada: " +coberturaAprox.size();
        result += "\nTamaño de la cobertura óptima: " + optima; 
        System.out.println(result);
    }
    private static boolean escobertura(Grafo grafo, ArrayList<Integer> coberturaAprox) {
        ArrayList<Arista> aristas = grafo.getA();
        for (Arista arista : aristas) {
            if(!(coberturaAprox.contains(arista.getU()) || coberturaAprox.contains(arista.getV()))) return false;
        }
        return true;
    }
    private static Grafo stringToGraph (String str){
        //Se quitan saltos de línea y dobles espacios 
        //y se separa en celdas
        String s[] = str.replace("\n", " ").replaceAll("[ ]+"," ").split(" "); 
        //Se espera que el primer numero sea el numero de vertices
        int numvertices = Integer.parseInt(s[0]);
        ArrayList  aristas = new ArrayList();
        for (int i = 1; i < s.length; i++) {
            if(Integer.parseInt(s[i])>0) 
                aristas.add(nuevaArista(i,numvertices)); 
        }
        return new Grafo(aristas);
    }

    private static Arista nuevaArista(int i, int numvertices) {
        return new Arista((i-1)%numvertices,(int)((i-1)/numvertices));
    }


}
