package modelo;

import java.util.Objects;

public class Conexion {

    /**
     * atributos de la clase
     * */
    private Equipo sourceNode;
    private Equipo targetNode;
    private String tipoConexion;
    private String bandwidth;
    private int latencia;
    private String status;
    private String errorRate;

    /**
     * Constructor de la clase
     * */
    public Conexion(Equipo sourceNode, Equipo targetNode, String tipoConexion, String bandwidth,
                    int latencia, String status, String errorRate) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
        this.tipoConexion = tipoConexion;
        this.bandwidth = bandwidth;
        this.latencia = latencia;
        this.status = status;
        this.errorRate = errorRate;
    }

    public Equipo getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Equipo sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Equipo getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(Equipo targetNode) {
        this.targetNode = targetNode;
    }

    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(String errorRate) {
        this.errorRate = errorRate;
    }

    @Override
    public String toString() {
        return "objetos.Conexion{" +
                "sourceNode=" + sourceNode +
                ", targetNode=" + targetNode +
                ", tipoConexion='" + tipoConexion + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", latencia=" + latencia +
                ", status='" + status + '\'' +
                ", errorRate='" + errorRate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conexion conexion = (Conexion) o;
        return Objects.equals(sourceNode, conexion.sourceNode) && Objects.equals(targetNode, conexion.targetNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceNode, targetNode);
    }
}