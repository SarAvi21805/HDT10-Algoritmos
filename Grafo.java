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

    public void eliminarVertice(int origen, int destino) {
        matrizAdyacencia[origen][destino] = Integer.MAX_VALUE;
    }

    public void algoritmoFloydWarshall() {
        for (int k = 0; k < V; k++) { /* iteración nodos intermedios */
            for (int i = 0; i < V; i++) { /* iteración nodos origen */
                for (int j = 0; j < V; j++) { /* iteración nodos destino */
                    if (matrizAdyacencia[i][k] != Integer.MAX_VALUE && matrizAdyacencia[k][j] != Integer.MAX_VALUE) { /* Búsqueda de caminos existentes de i a k y de k a j */
                        matrizAdyacencia[i][j] = Math.min(matrizAdyacencia[i][j], matrizAdyacencia[i][k] + matrizAdyacencia[k][j]); /* Actualización de distancia mínima de i a j comparada a la actual pasando por k */
                    }
                }
            }
        }
    }

    public void imprimirMatriz() {
        for (int[] fila : matrizAdyacencia) {
            for (int peso : fila) {
                if (peso == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(peso + " ");
                }
            }
            System.out.println();
        }
    }

    public int calcularCentroGrafo() {
        int centro = -1;
        int menorDistanciaMaxima = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            int maxDistancia = 0;
            for (int j = 0; j < V; j++) {
                if (matrizAdyacencia[i][j] != Integer.MAX_VALUE) {
                    maxDistancia = Math.max(maxDistancia, matrizAdyacencia[i][j]);
                }
            }
            if (maxDistancia < menorDistanciaMaxima) {
                menorDistanciaMaxima = maxDistancia;
                centro = i;
            }
        }
        return centro;
    }
}