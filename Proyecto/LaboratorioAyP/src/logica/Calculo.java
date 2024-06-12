package logica;

import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.*;

import java.util.TreeMap;



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
            for(java.util.Map.Entry<String, Equipo> equiposEntry : equipos.entrySet()){
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
}
