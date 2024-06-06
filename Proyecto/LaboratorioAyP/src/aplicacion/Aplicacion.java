package aplicacion;

import datos.CargarParametros;

import java.io.IOException;

public class Aplicacion {

    public static void main(String[] args) {

        try{
            CargarParametros.parametros();
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            System.exit(-1);
        }
    }
}
