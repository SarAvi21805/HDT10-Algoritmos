# Nombre: Alejandra Avilés
# Carnet: 24722
# Tarea: Hoja de Trabajo 10
# Fecha de entrega: 22 de mayo de 2025
# Fecha de última modificación: 22 de mayo de 2025
 
import networkx as nx

# Crear un grafo dirigido
grafo = nx.DiGraph()

# Agregar nodos y arcos con pesos
grafo.add_weighted_edges_from([
    ('A', 'B', 3),
    ('B', 'C', 1),
    ('A', 'D', 7),
    ('B', 'E', 8),
    ('D', 'E', 3),
    ('C', 'D', 2),
    ('E', 'A', 4)
])

# Calcular las distancias más cortas usando Floyd-Warshall
distancias = dict(nx.floyd_warshall(grafo))

# Imprimir la matriz de distancias
print("Matriz de distancias más cortas:")
for origen in distancias:
    print(f"{origen}: {distancias[origen]}")

# Calcular el centro del grafo
centro = min(distancias, key=lambda x: max(distancias[x].values()))
print(f"El centro del grafo es el nodo: {centro}")