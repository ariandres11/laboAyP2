package tests;

import datos.CargarParametros;
import datos.Datos;
import modelo.Conexion;
import modelo.Equipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

public class TestCargarParametros {

    TreeMap<String, Equipo> computadoras = null;
    TreeMap<String, Equipo> routers = null;
    TreeMap<String, Conexion> conexiones = null;

    @BeforeEach
    void setUp(){
        try{
            CargarParametros.parametros();
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            System.exit(-1);
        }

        try{
            Datos.cargarComputadoras(CargarParametros.getArchivoComputadora(), computadoras);

            Datos.cargarRouters(CargarParametros.getArchivoRouter(), routers);

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar el archivo de datos");
            System.exit(-1);
        }
    }

    @Test
    void testCargarParametros(){
        System.out.println(computadoras);
        System.out.println(routers);
    }






}
