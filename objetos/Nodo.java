package objetos;

import java.util.Objects;

/**
 * Se crea la clase Nodo con las propiedades de IP_ADDRESS, MAC_ADDRESS, status y ubicacion.
 * las propiedades van a ser usadas por dos clases, Computadora y Router.
 *
 * La clase es abstracta para que no se puedan instanciar objetos de esta clase.
 * */

public abstract class Nodo {

    /**
     * estos son los atributos de la clase.
     * */
    private String ID;
    private int IP_ADDRESS;
    private int MAC_ADDRESS;
    private String status;
    private String ubicacion;

    /**
     * Se hace el cpnstructor de la clase.
     * al constructor se le deben pasar las propiedades de IP_ADDRESS, MAC_ADDRESS,
     * status y ubicacion.
     * */
    public Nodo(String id, int ip_address, int mac_address, String status, String ubicacion){
        this.ID = id;
        this.IP_ADDRESS = ip_address;
        this.MAC_ADDRESS = mac_address;
        this.status = status;
        this.ubicacion = ubicacion;
    }

    /**
     * Se crean los get y set de los atributos de la clase.
     * el get sirve para obtener el valor de la variable y el set sirve para cambiar el valor de la variable.
     * */

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getIP_ADDRESS() {
        return IP_ADDRESS;
    }

    public void setIP_ADDRESS(int IP_ADDRESS) {
        this.IP_ADDRESS = IP_ADDRESS;
    }

    public int getMAC_ADDRESS() {
        return MAC_ADDRESS;
    }

    public void setMAC_ADDRESS(int MAC_ADDRESS) {
        this.MAC_ADDRESS = MAC_ADDRESS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "ID='" + ID + '\'' +
                ", IP_ADDRESS=" + IP_ADDRESS +
                ", MAC_ADDRESS=" + MAC_ADDRESS +
                ", status='" + status + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return IP_ADDRESS == nodo.IP_ADDRESS;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IP_ADDRESS);
    }
}
