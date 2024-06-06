package aplicacion;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;
import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;

public class GrafosObjetos {


    public static void main(String[] args) {

        // Crear el grafo
        Graph<Equipo, Conexion> g = new AdjacencyMapGraph<>(true);

        // Crear los nodos de tipo Equipo
        Equipo[] pc = new Computadora[5];
        pc[0] = new Computadora("pc1", 1, 2, true, "ubicacion");
        pc[1] = new Computadora("pc2", 3, 4, true, "ubicacion");
        pc[2] = new Computadora("pc3", 5, 6, true, "ubicacion");
        pc[3] = new Computadora("pc4", 7, 8, true, "ubicacion");
        pc[4] = new Computadora("pc5", 9, 10, true, "ubicacion");

        // Crear los nodos de tipo Router
        Equipo[] routers = new Router[3];
        routers[0] = new Router("router1", 1, 2, true, "ubicacion", "modelo", "firmware", "throughput");
        routers[1] = new Router("router2", 3, 4, true, "ubicacion", "modelo", "firmware", "throughput");
        routers[2] = new Router("router3", 5, 6, true, "ubicacion", "modelo", "firmware", "throughput");

        // Creo los edges
        Conexion[] conexiones = new Conexion[11];
        conexiones[0] = new Conexion(pc[0], routers[0], "tipo", "bandwidth", 1, "status", "errorRate");
        conexiones[1] = new Conexion(pc[1], routers[1], "tipo", "bandwidth", 1, "status", "errorRate");
        //Seguir con los demas (NO SE LO DEMAS QUE HABRIA QUE HACER)


        // Crear los vertices
        Vertex<Equipo> pc0 = g.insertVertex(pc[0]);
        Vertex<Equipo> pc1 = g.insertVertex(pc[1]);
        Vertex<Equipo> pc2 = g.insertVertex(pc[2]);
        Vertex<Equipo> pc3 = g.insertVertex(pc[3]);
        Vertex<Equipo> pc4 = g.insertVertex(pc[4]);

        Vertex<Equipo> router0 = g.insertVertex(routers[0]);
        Vertex<Equipo> router1 = g.insertVertex(routers[1]);
        Vertex<Equipo> router2 = g.insertVertex(routers[2]);


        //crear las conexiones entre los vertices
        Edge<Conexion> c1 = g.insertEdge(pc0, router0, conexiones[0]);





    }

    //Vertex<Equipo> pc2 = g.insertVertex(pc1);


}
