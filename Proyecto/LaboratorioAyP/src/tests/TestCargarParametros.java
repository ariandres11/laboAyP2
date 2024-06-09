package tests;

import datos.CargarParametros;
import modelo.Conexion;
import modelo.Equipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.TreeMap;

public class TestCargarParametros {

    TreeMap<String, Equipo> computadoras = null;
    TreeMap<String, Equipo> routers = null;
    TreeMap<String, Conexion> conexiones = null;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testCargarParametros(){
        try{
            CargarParametros.parametros();

            System.out.println("Archivo Computadora: " + CargarParametros.getArchivoComputadora());
            System.out.println("Archivo Router: " + CargarParametros.getArchivoRouter());
            System.out.println("Archivo Conexion: " + CargarParametros.getArchivoConexion());

        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            System.exit(-1);
        }
    }






}
