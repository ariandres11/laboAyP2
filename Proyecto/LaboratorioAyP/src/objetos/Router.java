package objetos;

public class Router extends Nodo {

    /**
     * estos son los atributos de la clase.
     * */
    private String modelo;
    private String firmware;
    private String throughput;

    /**
     * El super constructor de la clase, esto porque extiende de una clase abtracta objetos.Nodo.
     * Ademas se le pasan los atributos especificos de la clase.
     * */
    public Router(String id, int ip_address, int mac_address, String status, String ubicacion,
                  String modelo, String firmware, String throughput) {
        super(id, ip_address, mac_address, status, ubicacion);

        this.modelo = modelo;
        this.firmware = firmware;
        this.throughput = throughput;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getFirmware() {
        return firmware;
    }
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }
    public String getThroughput() {
        return throughput;
    }
    public void setThroughput(String throughput) {
        this.throughput = throughput;
    }

    /**
     * El toString para que muestre los atributos extra de la clase.
     * */
    @Override
    public String toString() {
        return "objetos.Router{" +
                "modelo='" + modelo + '\'' +
                ", firmware='" + firmware + '\'' +
                ", throughput='" + throughput + '\'' +
                '}';
    }
}
