package tests;

import datos.CargarParametros;
import datos.Datos;
import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.Entry;
import net.datastructures.List;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class prueba {
    public static void main(String[] args) {

        TreeMap<String, Equipo> equipos = null;
        List<Conexion> conexiones = null;

        try{
            CargarParametros.parametros();

            System.out.println("Archivo Computadora: " + CargarParametros.getArchivoComputadora());
            System.out.println("Archivo Router: " + CargarParametros.getArchivoRouter());
            System.out.println("Archivo Conexion: " + CargarParametros.getArchivoConexion());

        }catch(IOException e){
            System.err.print("Error en la carga de parametros" + e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }

        try {

            equipos = Datos.cargarEquipos(CargarParametros.getArchivoComputadora(), CargarParametros.getArchivoRouter());
            conexiones = Datos.cargarConexiones(CargarParametros.getArchivoConexion(), equipos);


        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos");
            System.exit(-1);
        }

        System.out.println("Todos los equipos con claves y valores");
        for (Map.Entry<String, Equipo> entry : equipos.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
        }


        System.out.println("Todas las conexiones");
        for (Conexion i : conexiones) {
            System.out.println(i);
        }

    }
}
