package com.soulblack99.IoC;

public class SecretarioEmpleado implements Empleados {

	private CreacionInformes informe;

    public SecretarioEmpleado(CreacionInformes informe) {
        this.informe = informe;
    }
    
    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }
    
    @Override
    public String getInforme() {
        return "Informe del secretario: " + informe.getInforme();
    }
}