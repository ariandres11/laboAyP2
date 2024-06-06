package test;

import datos.CargarParametros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestCargarParametros {

    @BeforeEach
    void setUp(){
        try{
            CargarParametros.parametros();
        }catch(IOException e){
            System.err.print("Error en la carga de parametros");
            System.exit(-1);
        }
    }




}
