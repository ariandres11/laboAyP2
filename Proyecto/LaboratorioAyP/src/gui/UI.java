package gui;

import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.List;

import java.util.TreeMap;

public class UI {

    public static Equipo ingresarEquipoOrigen(TreeMap<String,Equipo> equipos){
        return equipos.get("Router 1");
    }

    public static Equipo ingresarEquipoDestino(TreeMap<String, Equipo> equipos){
        return equipos.get("Compu 1");
    }

    public static void mostrarConexion(List<Conexion> conexiones){
        //Mostrar los datos de la conexion entre dos equipos

    }
}
