package sv.com.telecomunicaciones.bins;

public class EmployeeBeans {
    int idEmployee;
    String nameEmployee;
    String surnameEmployee;
    int rolEmployee;
    String areaEmployee;

    public EmployeeBeans(int idEmployee, String nameEmployee, String surnameEmployee, int rolEmployee, String areaEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.surnameEmployee = surnameEmployee;
        this.rolEmployee = rolEmployee;
        this.areaEmployee = areaEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getSurnameEmployee() {
        return surnameEmployee;
    }

    public void setSurnameEmployee(String surnameEmployee) {
        this.surnameEmployee = surnameEmployee;
    }

    public int getRolEmployee() {
        return rolEmployee;
    }

    public void setRolEmployee(int rolEmployee) {
        this.rolEmployee = rolEmployee;
    }

    public String getAreaEmployee() {
        return areaEmployee;
    }

    public void setAreaEmployee(String areaEmployee) {
        this.areaEmployee = areaEmployee;
    }
}
