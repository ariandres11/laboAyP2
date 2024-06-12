package datos;

import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;
import net.datastructures.ArrayList;
import net.datastructures.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Dato {

    public static TreeMap<String, Equipo> cargarEquipos(String fileComputadora,
                                                        String fileRouter) throws FileNotFoundException {
        TreeMap<String, Equipo> equipos = new TreeMap<>();

        cargarComputadoras(fileComputadora, equipos);
        cargarRouters(fileRouter, equipos);

       return equipos;
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

    public static List<Conexion> cargarConexiones(String filename, TreeMap<String, Equipo> equipos ) throws FileNotFoundException {
            Scanner read;
            List<Conexion> conexiones = new ArrayList<Conexion>();
            read = new Scanner(new File(filename));
            read.useDelimiter("\\s*;\\s*");

            Equipo sourceNode, targetNode;
            String tipoConexion, bandwidth, status, errorRate;
            int latencia;

            while (read.hasNext()) {
                sourceNode = equipos.get(read.next());
                targetNode = equipos.get(read.next());
                tipoConexion = read.next();
                bandwidth = read.next();
                latencia = Integer.parseInt(read.next());
                status = read.next();
                errorRate = read.next();

                if(sourceNode != null && targetNode != null){
                    conexiones.add(0, new Conexion(sourceNode, targetNode, tipoConexion, bandwidth, latencia, status, errorRate));
                }

            }
            read.close();

            return conexiones;

    }
}
