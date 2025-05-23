public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        // A: 0, B: 1, C: 2, D: 3, E: 4
        grafo.agregarVertice(0, 1, 3); // A -> B
        grafo.agregarVertice(1, 2, 1); // B -> C
        grafo.agregarVertice(0, 3, 7); // A -> D
        grafo.agregarVertice(1, 4, 8); // B -> E
        grafo.agregarVertice(3, 4, 3); // D -> E
        grafo.agregarVertice(2, 3, 2); // C -> D
        grafo.agregarVertice(4, 0, 4); // E -> A

        System.out.println("Matriz de adyacencia inicial:");
        grafo.imprimirMatriz();

        grafo.algoritmoFloydWarshall();
        System.out.println("Matriz de adyacencia después de aplicar Floyd-Warshall:");
        grafo.imprimirMatriz();

        int centro = grafo.calcularCentroGrafo();
        System.out.println("El centro del grafo es el vértice: " + centro);
    }
}