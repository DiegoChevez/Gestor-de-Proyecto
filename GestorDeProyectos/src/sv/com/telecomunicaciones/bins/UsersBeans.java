package sv.com.telecomunicaciones.bins;

public class UsersBeans {
        int idUser;
        String employeeUser;
        String user;
        String status;

    public UsersBeans(int idUser, String employeeUser, String user, String status) {
        this.idUser = idUser;
        this.employeeUser = employeeUser;
        this.user = user;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(String employeeUser) {
        this.employeeUser = employeeUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
