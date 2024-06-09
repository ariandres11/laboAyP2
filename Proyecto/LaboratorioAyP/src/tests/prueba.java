package tests;

import datos.CargarParametros;

import java.io.IOException;

public class prueba {
    public static void main(String[] args) {

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
    }
}
