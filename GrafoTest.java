import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5);
        grafo.agregarVertice(0, 1, 3); // A -> B
        grafo.agregarVertice(1, 2, 1); // B -> C
        grafo.agregarVertice(0, 3, 7); // A -> D
        grafo.agregarVertice(1, 4, 8); // B -> E
        grafo.agregarVertice(3, 4, 3); // D -> E
        grafo.agregarVertice(2, 3, 2); // C -> D
        grafo.agregarVertice(4, 0, 4); // E -> A
        grafo.agregarVertice(2, 1, 2); // C -> B
      //  grafo.agregarVertice(3, 1, 1); // D -> B
    }

    @Test
    public void testAgregarVertice() {
        grafo.agregarVertice(0, 2, 5); // A -> C
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(5, matriz[0][2]);
    }

        @Test
    public void testEliminarVertice() {
        grafo.eliminarVertice(0, 1); // A -> B
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
        assertEquals(0, centro); // B es el centro
    }
}