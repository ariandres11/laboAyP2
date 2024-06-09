package tests;

import datos.CargarParametros;

import java.io.IOException;

public class prueba {
    public static void main(String[] args) {

        try{
            CargarParametros.parametros();

            System.out.println("Archivo Computadora: " + CargarParametros.getArchivoComputadora());
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            System.exit(-1);
        }
    }
}
