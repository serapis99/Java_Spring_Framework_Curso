package com.soulblack99.IoC;

public class DirectorEmpleado implements Empleados {

	private CreacionInformes informe;

	public void setInforme(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getInforme() {
        return "Informe del director: " + informe.getInforme();
    }
    
    @Override
    public String getTareas() {
        return "Toma de decisiones";
    }
}