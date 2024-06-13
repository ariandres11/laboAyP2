package tests;

import datos.CargarParametros;
import datos.Dato;
import modelo.Conexion;
import modelo.Equipo;
import net.datastructures.Entry;
import net.datastructures.TreeMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
            equipos = Dato.cargarEquipos(CargarParametros.getArchivoComputadora(), CargarParametros.getArchivoRouter());

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos EQUIPOS");
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            conexiones = Dato.cargarConexiones(CargarParametros.getArchivoConexion(), equipos);

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos CONEXIONES");
            e.printStackTrace();
            System.exit(-1);
        }



        System.out.println("Todos los equipos con claves y valores");
        for (Entry<String, Equipo> entry : equipos.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
        }


        System.out.println("Todas las conexiones");
        int a = 1;
        for (Conexion i : conexiones) {
            System.out.println(a + ". " + i);
            a++;
        }

    }
}
