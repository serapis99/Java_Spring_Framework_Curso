package co.soulblack.IoC;

public class UsoEmpleados {

	public static void main(String[] args) {

        // Creación directa del objeto (control tradicional)
        Empleados empleado1 = new SecretarioEmpleado();

        // Uso del objeto creado
        System.out.print(empleado1.getTareas());
    }

}
