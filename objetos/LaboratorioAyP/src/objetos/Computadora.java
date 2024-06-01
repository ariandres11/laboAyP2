package objetos;

public class Computadora extends Nodo {
    String id;
    int ip_adress;
    int mac_address;
    String status;
    String ubicacion;

    public Computadora(String id, int ip_address, int mac_address, String status, String ubicacion) {
        super(id, ip_address, mac_address, status, ubicacion);
    }


}
