package tests;

import datos.CargarParametros;
import datos.Dato;
import logica.Calculo;
import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.TreeMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

        Calculo calculo = new Calculo(equipos, conexiones);

        Equipo e1 = equipos.get("Comp1");
        Equipo e2 = equipos.get("Comp2");

        if(e1 == null || e2 == null){
            System.err.println("Uno de los dos equipos esta mal");
            System.exit(-1);
        }

        List<Conexion> camino = calculo.caminoRapido(e1, e2);
        System.out.println("Camino mas rapido de " + e1.getID() + " a " + e2.getID() + " es: ");
        for(Conexion conexion : camino){
            if(camino.getLast().equals(conexion)){
                System.out.println(conexion.getSourceNode().getID() + "->" + conexion.getTargetNode().getID());
            }
            else{
                System.out.print(conexion.getSourceNode().getID() + "->" + conexion.getTargetNode().getID() + "->");
            }
        }


    }

}

/*
System.out.println(conexion.getSourceNode().getID() + "->" + conexion.getTargetNode().getID()
                                + "| Ancho de banda: " + conexion.getBandwidth() + "Mbps.");
*/
