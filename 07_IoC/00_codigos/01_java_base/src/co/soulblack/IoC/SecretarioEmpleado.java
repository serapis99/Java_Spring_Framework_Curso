package co.soulblack.IoC;

public class SecretarioEmpleado implements Empleados {
    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }
}
