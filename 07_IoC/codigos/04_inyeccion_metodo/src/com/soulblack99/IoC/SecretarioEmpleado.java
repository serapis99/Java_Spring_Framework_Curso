package com.soulblack99.IoC;

public class SecretarioEmpleado implements Empleados {

	private CreacionInformes informe;

    public void setInforme(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getInforme() {
        return "Informe de la secretaria: " + informe.getInforme();
    }
    
    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }
    
}