package datos;

import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;
import net.datastructures.TreeMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


        while (read.hasNext()) {
            id = read.next();
            ipAddress = Integer.parseInt(read.next());
            macAddress = Integer.parseInt(read.next());
            status = Boolean.parseBoolean(read.next());
            ubicacion = read.next();
            //Crea un nuevo equipo Computadora y lo agrego al mapa de equipos

            equipos.put(id, new Computadora(id, ipAddress, macAddress, status, ubicacion));
        }
        //Cierra el archivo
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

            //Crea un nuevo equipo Router y lo agrego al mapa de equipos
            equipos.put(id, new Router(id, ipAddress, macAddress, status, ubicacion, modelo, firmware, throughput));
        }

        read.close();

    }

    /**
     * El metodo cargarConexiones se va a encargar de conectar un router con una computadora
     * u otro router, una computadora no puede ser la salida(source) y no puede estar
     * conectada a mas de 1 router.
     *
     * -Devuleve una lista de conexiones
     * -El metodo pide que se le pase un string con el nombre del archivo al lerr y el arbol
     * que contiene los equipos(routers y computadoras).
     * */
    public static List<Conexion> cargarConexiones(String filename, TreeMap<String, Equipo> equipos ) throws FileNotFoundException {
            //Cargar archivo y sus variables para la lectura con su delimitador
            Scanner read;
            read = new Scanner(new File(filename));
            read.useDelimiter("\\s*;\\s*");

            List<Conexion> conexiones = new ArrayList<Conexion>(); //Lista de conexiones
            TreeMap<String, Boolean> compConectadas = new TreeMap<>(); //Mapa de computadoras que SI estan conectadas


            //Las variables que se utilizan para crear una conexion
            Equipo sourceNode, targetNode;
            String tipoConexion, status, errorRate, latencia;
            Double bandwidth;

            //Lee el archvio Conexiones.txt hasta el final
            while (read.hasNext()) {
                sourceNode = equipos.get(read.next());
                targetNode = equipos.get(read.next());
                tipoConexion = read.next();
                bandwidth = read.nextDouble();
                latencia = read.next();
                status = read.next();
                errorRate = read.next();

                if(sourceNode != null && targetNode != null){ //Si los dos nodos existen
                    if(!(sourceNode instanceof Computadora)){ //Si el source es un router
                        if(targetNode instanceof Computadora){ //Si el target es una computadora
                            if(compConectadas.get(targetNode.getID()) == null){ //Si la computadora NO existe en el mapa de computadoras conectadas
                                compConectadas.put(targetNode.getID(), true);
                                conexiones.add(0, new Conexion(sourceNode, targetNode, tipoConexion, bandwidth, latencia, status, errorRate));
                            }
                        }
                        else{ //Si el target es un router
                            conexiones.add(new Conexion(sourceNode, targetNode, tipoConexion, bandwidth, latencia, status, errorRate));
                        }

                    }

                }
            }
            //Cierra el archivo
            read.close();

            //Retorna las conexiones en forma de lista
            return conexiones;
    }
}
