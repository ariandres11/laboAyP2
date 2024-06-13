package logica;

import modelo.Conexion;
import modelo.Equipo;

import net.datastructures.*;

import java.util.ArrayList;
import java.util.List;


public class Calculo {

            //Grafo del sistema que contiene los equipos y sus conexiones
            private Graph<Equipo, Conexion> sistema; //Los equipos van a ser los vertices y las conexiones van a ser las aristas
            //Mapa de vertices
            private TreeMap<String, Vertex<Equipo>> vertices; //El mapa va a tener un id y el dato tipo vertice que es Equipo

            //Constructor de la clase Calculo (crea el grafo)
    public Calculo(TreeMap<String, Equipo> equipos, List<Conexion> conexiones) {

            sistema = new AdjacencyMapGraph<Equipo, Conexion>(false);
            vertices = new TreeMap<String, Vertex<Equipo>>();

            /**
             * Carga los vertices del grafo que son los equipos(routers y computadoras)
             * -En el grafo inserta los vertices
             * -En el TreeMap tambien inserta los vertices, esto para ser utilizado mas tarde para
             * cargar las aristas
             * */
            for(Entry<String, Equipo> equiposEntry : equipos.entrySet()){
                vertices.put(equiposEntry.getKey(), sistema.insertVertex(equiposEntry.getValue()));
            }

            //Cargar conexiones
            for(Conexion conexionesLista : conexiones){
                sistema.insertEdge(vertices.get(conexionesLista.getSourceNode().getID()), //Agrega la arista que toma el id del source y el id del target
                        vertices.get(conexionesLista.getTargetNode().getID()), conexionesLista);
            }

    }

    //Para ver como quedo el grafo habilitar este metodo
    //public Graph<Equipo, Conexion> getGrafo(){ return sistema; }

    public List<Conexion> caminoRapido(Equipo equipo1, Equipo equipo2) {
        //Copiamos el grafo
        Graph<Equipo, Integer> camRap = new AdjacencyMapGraph<Equipo, Integer>(false);
        Map<Equipo, Vertex<Equipo>> res = new ProbeHashMap<>();

        for(Vertex<Equipo> result : sistema.vertices()){
            res.put(result.getElement(), camRap.insertVertex(result.getElement()));
        }

        Vertex<Equipo>[] vertice;

        for(Edge<Conexion> result : sistema.edges()){
            vertice = sistema.endVertices(result);
            double band = 1 / result.getElement().getBandwidth() * 10000;
            int anchoBanda = (int) band;
            camRap.insertEdge(res.get(vertice[0].getElement()), res.get(vertice[1].getElement()), anchoBanda);
        }

        PositionalList<Vertex<Equipo>> lista = GraphAlgorithms.shortestPathList(camRap, res.get(equipo1), res.get(equipo2));

        List<Conexion> conexiones = new ArrayList<>();

        Vertex<Equipo> e1, e2;
        Position<Vertex<Equipo>> aux = lista.first();
        while(lista.after(aux) != null){
            e1 = aux.getElement();
            aux = lista.after(aux);
            e2 = aux.getElement();
            conexiones.add(sistema.getEdge(vertices.get(e1.getElement().getID()), vertices.get(e2.getElement().getID())).getElement());
        }
                return conexiones;

    }

}
