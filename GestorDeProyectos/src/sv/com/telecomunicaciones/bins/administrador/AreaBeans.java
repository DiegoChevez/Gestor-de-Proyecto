package sv.com.telecomunicaciones.bins.administrador;

public class AreaBeans {
    String idArea;
    String area;

    public AreaBeans(String idArea, String area) {
        this.idArea=idArea;
        this.area=area;

    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
