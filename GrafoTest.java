/* 
 * Nombre: Alejandra Avilés
 * Carnet: 24722
 * Tarea: Hoja de Trabajo 10
 * Fecha de entrega: 22 de mayo de 2025
 * Fecha de última modificación: 22 de mayo de 2025
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5);
        grafo.agregarArista(0, 1, 3); // A -> B
        grafo.agregarArista(1, 2, 1); // B -> C
        grafo.agregarArista(0, 3, 7); // A -> D
        grafo.agregarArista(1, 4, 8); // B -> E
        grafo.agregarArista(3, 4, 3); // D -> E
        grafo.agregarArista(2, 3, 2); // C -> D
        grafo.agregarArista(4, 0, 4); // E -> A
        grafo.agregarArista(2, 1, 2); // C -> B
      //  grafo.agregarVertice(3, 1, 1); // D -> B
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarArista(0, 2, 5); // A -> C
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(5, matriz[0][2]);
    }

        @Test
    public void testEliminarArista() {
        grafo.eliminarArista(0, 1); // A -> B
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(Integer.MAX_VALUE, matriz[0][1]);
    }

     @Test
    public void testAlgoritmoFloydWarshall() {
        grafo.algoritmoFloydWarshall();
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(4, matriz[0][2]); // A -> C
    }

    @Test
    public void testCalcularCentroGrafo() {
        grafo.algoritmoFloydWarshall();
        int centro = grafo.calcularCentroGrafo();
        assertEquals(0, centro); // A es el centro
    }
}