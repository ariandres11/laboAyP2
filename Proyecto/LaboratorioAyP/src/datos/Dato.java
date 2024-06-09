package datos;

import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;
import net.datastructures.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Dato {

    public static TreeMap<String, Equipo> cargarEquipos(String fileComputadora, String fileRouter) throws FileNotFoundException {
        TreeMap<String, Equipo> equipos = new TreeMap<>();
        cargarComputadoras(fileComputadora, equipos);
        cargarRouters(fileRouter, equipos);



       return null;
    }



    public static void cargarComputadoras(String fileName, TreeMap<String, Equipo> equipos) throws FileNotFoundException {

        Scanner read;

        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");
        String id, ubicacion;
        int ipAddress, macAddress;
        boolean status;

        //Si es router

        while (read.hasNext()) {
            id = read.next();
            ipAddress = Integer.parseInt(read.next());
            macAddress = Integer.parseInt(read.next());
            status = Boolean.parseBoolean(read.next());
            ubicacion = read.next();

            equipos.put(id, new Computadora(id, ipAddress, macAddress, status, ubicacion));
        }

        read.close();

    }

    public static void cargarRouters(String fileName, TreeMap<String, Equipo> equipos) throws FileNotFoundException {

        Scanner read;


        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");
        String id, ubicacion, modelo, firmware, throughput;
        int ipAddress, macAddress;
        boolean status;

        while (read.hasNext()) {
            id = read.next();
            ipAddress = Integer.parseInt(read.next());
            macAddress = Integer.parseInt(read.next());
            status = Boolean.parseBoolean(read.next());
            ubicacion = read.next();
            modelo = read.next();
            firmware = read.next();
            throughput = read.next();

            equipos.put(id, new Router(id, ipAddress, macAddress, status, ubicacion, modelo, firmware, throughput));
        }

        read.close();

    }

    public static ArrayList cargarConexiones(String filename, TreeMap<String, Equipo> equipos ) throws FileNotFoundException {
            Scanner read;
            ArrayList<Conexion> conexiones = new ArrayList<Conexion>();
            read = new Scanner(new File(filename));
            read.useDelimiter("\\s*;\\s*");
            Equipo v1, v2;
            String velocidad;
            int tiempo, tipo;
            while (read.hasNext()) {
                v1 = equipos.get(read.next());
                v2 = equipos.get(read.next());
                velocidad = read.next();
                //conexiones.add(0, new Conexion(v1, v2, velocidad));
            }
            read.close();

            return conexiones;

    }
}
