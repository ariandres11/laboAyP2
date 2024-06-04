package objetos;

import java.util.Objects;

/**
 * Se crea la clase objetos.Nodo con las propiedades de IP_ADDRESS, MAC_ADDRESS, status y ubicacion.
 * las propiedades van a ser usadas por dos clases, Computadora y objetos.Router.
 *
 * La clase es abstracta para que no se puedan instanciar objetos de esta clase.
 * */

public abstract class Nodo {

    /**
     * estos son los atributos de la clase.
     */
    private String ID;
    private int ipAddress;
    private int macAddress;
    private String status;
    private String ubicacion;

    /**
     * Se hace el cpnstructor de la clase.
     * al constructor se le deben pasar las propiedades de IP_ADDRESS, MAC_ADDRESS,
     * status y ubicacion.
     */
    public Nodo(String id, int ipAddress, int macAddress, String status, String ubicacion) {
        this.ID = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
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

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(int macAddress) {
        this.macAddress = macAddress;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return ipAddress == nodo.ipAddress && macAddress == nodo.macAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, macAddress);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "ID='" + ID + '\'' +
                ", ipAddress=" + ipAddress +
                ", macAddress=" + macAddress +
                ", status='" + status + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
