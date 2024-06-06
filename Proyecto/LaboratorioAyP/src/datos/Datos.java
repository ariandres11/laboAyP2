package datos;

import modelo.Computadora;
import modelo.Equipo;
import modelo.Router;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Datos {

    public static TreeMap<String, Equipo> cargarEquipos(String fileName) throws FileNotFoundException {

        if (fileName == "computadora.txt") {
            return cargarComputadoras(fileName);
        } else {
            if (fileName == "router.txt") {
                return cargarRouters(fileName);
            }
        }
       return null;
    }



    public static TreeMap<String, Equipo> cargarComputadoras(String fileName) throws FileNotFoundException {

        Scanner read;

        TreeMap<String, Equipo> computadoras = new TreeMap<String, Equipo>();

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

            computadoras.put(id, new Computadora(id, ipAddress, macAddress, status, ubicacion);
        }

        read.close();

        return computadoras;

    }

    public static TreeMap<String, Equipo> cargarRouters(String fileName) throws FileNotFoundException {

        Scanner read;

        TreeMap<String, Equipo> routers = new TreeMap<String, Equipo>();

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

            routers.put(id, new Router(id, ipAddress, macAddress, status, ubicacion, modelo, firmware, throughput);
        }

        read.close();

        return routers;

    }
}
