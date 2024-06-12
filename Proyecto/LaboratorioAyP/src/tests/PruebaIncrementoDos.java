package tests;

import datos.CargarParametros;
import datos.Dato;

import modelo.Computadora;
import modelo.Conexion;
import modelo.Equipo;
import modelo.Router;
import net.datastructures.List;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class PruebaIncrementoDos {
    public static void main(String[] args) throws IOException, InterruptedException {


        //Estucturas que vana contener a los equipos y las conexiones
        TreeMap<String,Equipo> equipos = null;
        List<Conexion> conexiones = null;

        //Carga de parametros (que archivo leer para computadora, router y conexion)
        try{
            CargarParametros.parametros();
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            e.printStackTrace();
            System.exit(-1);
        }

        //Carga de archivos equipo(computadora y router) y conexiones
        try {
            equipos = Dato.cargarEquipos(CargarParametros.getArchivoComputadora(), CargarParametros.getArchivoRouter());
            conexiones = Dato.cargarConexiones(CargarParametros.getArchivoConexion(), equipos);

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos");
            e.printStackTrace();
            System.exit(-1);
        }

        //Para saber que esta todo bien o todo mal
        System.out.println("Todo bien"); //ELIMINAR DESPUES

        //variables para el manejo de la interfaz
        Scanner lector = new Scanner(System.in);
        int eleccion = 1;

        //Hacer metodos fuera del main para cada elección asi queda ordenado ELIMINAR DESPUES ESTE COMENTARIO
        do{
            System.out.println("1. Ping" + "\n2. Traceroute" + "\n3. Arbol de expansion de peso minimo" +
                                "\n0. Salir");
            eleccion = lector.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Funciona 1");
                    break;

                case 2:
                    System.out.println("Funciona 2");
                    break;

                case 3:
                    System.out.println("Funciona 3");
                    break;

                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }while(eleccion != 0);
     lector.close();
    }
}
