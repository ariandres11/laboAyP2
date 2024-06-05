package datos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CargarParametros {

    private static String archivoConexion;
    private static String archivoEquipo;

    public static void parametros() throws IOException{

        Properties prop = new Properties();
        InputStream input = new FileInputStream("config.properties");
        prop.load(input);

        archivoConexion = prop.getProperty("conexion");
        archivoEquipo = prop.getProperty("equipo");


    }

    public static String getArchivoConexion() {
        return archivoConexion;
    }

    public static String getArchivoEquipo() {
        return archivoEquipo;
    }
}
