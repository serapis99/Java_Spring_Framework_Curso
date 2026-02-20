package com.soulblack99.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SecretarioEmpleado juan = contexto.getBean("miEmpleado", SecretarioEmpleado.class);
		
		System.out.println(juan.getTareas());
		System.out.println(juan.getInforme());
		System.out.println(juan.getNombreEmpresa());
		System.out.println(juan.getEmail());
		contexto.close();

	}

}
