package aplicacion;

import datos.CargarParametros;
import datos.Dato;

import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;
import net.datastructures.SinglyLinkedList;
import net.datastructures.TreeMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {

        TreeMap<String,Equipo> equipos = null;
        SinglyLinkedList<Conexion> conexiones = null;

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
        System.out.println("Todo bien"); //ELIMINAR DESPUES

    }
}
