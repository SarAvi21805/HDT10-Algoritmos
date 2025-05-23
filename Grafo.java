/* 
 * Nombre: Alejandra Avilés
 * Carnet: 24722
 * Tarea: Hoja de Trabajo 10
 * Fecha de entrega: 22 de mayo de 2025
 * Fecha de última modificación: 22 de mayo de 2025
 */

import java.util.Arrays;

/**
 * Clase que representa un grafo dirigido utilizando una matriz de adyacencia.
 * Permite agregar y eliminar aristas, calcular caminos mínimos con el algoritmo
 * de Floyd-Warshall y determinar el centro del grafo.
 */
public class Grafo {
    private final int V; // Número de vértices
    private final int[][] matrizAdyacencia; // Matriz de adyacencia

    /**
     * Constructor que inicializa el grafo con un número dado de vértices.
     * La matriz de adyacencia se inicializa con infinito (Integer.MAX_VALUE)
     * para representar la ausencia de aristas, y 0 en la diagonal principal.
     *
     * @param V número de vértices del grafo
     */
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

    /**
     * Devuelve una copia de la matriz de adyacencia actual del grafo.
     *
     * @return copia de la matriz de adyacencia
     */
    public int[][] getMatrizAdyacencia() {
        int[][] copia = new int[V][V];
        for (int i = 0; i < V; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, copia[i], 0, V);
        }
        return copia;
    }

    /**
     * Agrega una arista dirigida desde el vértice origen al vértice destino con un peso dado.
     *
     * @param origen  índice del vértice origen
     * @param destino índice del vértice destino
     * @param peso    peso de la arista
     */
    public void agregarArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }

    /**
     * Elimina la arista dirigida desde el vértice origen al vértice destino,
     * estableciendo su peso a infinito (sin conexión).
     *
     * @param origen  índice del vértice origen
     * @param destino índice del vértice destino
     */
    public void eliminarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = Integer.MAX_VALUE;
    }

    /**
     * Aplica el algoritmo de Floyd-Warshall para calcular las distancias mínimas
     * entre todos los pares de vértices en el grafo.
     * Actualiza la matriz de adyacencia con las distancias mínimas encontradas.
     */
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

    /**
     * Imprime la matriz de adyacencia en consola, mostrando "∞" para distancias infinitas.
     */
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

    /**
     * Calcula el centro del grafo, definido como el vértice que minimiza la distancia máxima
     * a todos los demás vértices.
     *
     * @return índice del vértice centro del grafo
     */
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