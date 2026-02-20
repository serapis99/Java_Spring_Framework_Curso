package com.soulblack99.IoC;

public class SecretarioEmpleado implements Empleados {

	private CreacionInformes informe;
	private String email;
	private String nombreEmpresa;

    public void setInforme(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getInforme() {
        return "Informe de la secretaria: " + informe.getInforme();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }
    
    public void metodoInicial() {
        System.out.println("Aqui se ejecutan las tareas antes de que el bean este listo");
    }

    public void metodoFinal() {
        System.out.println("Aqui se ejecutan las tareas despues de destruir el bean");
    }
    
}