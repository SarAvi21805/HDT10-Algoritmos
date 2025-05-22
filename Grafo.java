import java.util.Arrays;

public class Grafo {
    private final int V; // Número de vértices
    private final int[][] matrizAdyacencia; // Matriz de adyacencia

    public Grafo(int V) {
        this.V = V;
        matrizAdyacencia = new int[V][V];
        for (int[] fila : matrizAdyacencia) {
            Arrays.fill(fila, Integer.MAX_VALUE); // Inicializar con infinito
        }
        for (int i = 0; i < V; i++) {
            matrizAdyacencia[i][i] = 0; // Distancia a sí mismo
        }
    }

    public int[][] getMatrizAdyacencia() {
        int[][] copia = new int[V][V];
        for (int i = 0; i < V; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, copia[i], 0, V);
        }
        return copia;
    }

    public void agregarVertice(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }
}
