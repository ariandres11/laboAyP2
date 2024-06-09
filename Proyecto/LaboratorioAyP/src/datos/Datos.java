package datos;

import modelo.Computadora;
import modelo.Equipo;
import modelo.Router;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Datos {

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
}
