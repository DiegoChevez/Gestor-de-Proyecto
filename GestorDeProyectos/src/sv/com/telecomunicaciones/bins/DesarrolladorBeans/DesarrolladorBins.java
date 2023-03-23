package sv.com.telecomunicaciones.bins.DesarrolladorBeans;


import javax.swing.*;

public class DesarrolladorBins {

            String idCaso;
            String solicitante;
            String descripcion;
            String estado;
            String idSolicitudP;

    private JTextField txtId;

            public DesarrolladorBins(String idCaso, String solicitante, String descripcion, String estado){
                this.idCaso = idCaso;
                this.solicitante = solicitante;
                this.descripcion = descripcion;
                this.estado = estado;
            }



    public String getIdCaso() {

                return idCaso;
    }

    public void setIdCaso(String idCaso) {

                this.idCaso = idCaso;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String setIdSPro(String idSolicitudP){
        this.idSolicitudP = idSolicitudP;
        txtId.setText(idSolicitudP);
        return idSolicitudP;
    }
}
