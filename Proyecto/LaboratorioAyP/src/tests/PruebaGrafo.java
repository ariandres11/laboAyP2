package tests;

import datos.CargarParametros;
import datos.Dato;
import logica.Calculo;
import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

public class PruebaGrafo {

    public static void main(String[] args) {

        TreeMap<String, Equipo> equipos = null;
        List<Conexion> conexiones = null;

        try{
            CargarParametros.parametros();
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            e.printStackTrace();
            System.exit(-1);
        }


        try {

            equipos = Dato.cargarEquipos(CargarParametros.getArchivoComputadora(), CargarParametros.getArchivoRouter());
            conexiones = Dato.cargarConexiones(CargarParametros.getArchivoConexion(), equipos);

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos");
            e.printStackTrace();
            System.exit(-1);
        }
        /* PARA VER COMO QUEDO EL GRAFO ELIMINAR LOS ASTERICOS Y BARRAS

        Calculo calculo = new Calculo(equipos, conexiones);
        Graph<Equipo, Conexion> sistema = new AdjacencyMapGraph<Equipo, Conexion>(false);
        sistema = calculo.getGrafo();

        System.out.println("Número de vértices: " + sistema.numVertices());
        System.out.println("Número de arcos: " + sistema.numEdges());

        for (Vertex<Equipo> vert : sistema.vertices())
            System.out.println(vert.getElement());

        for (Edge<Conexion> arc : sistema.edges())
            System.out.println(arc.getElement());
        */
    }

}
