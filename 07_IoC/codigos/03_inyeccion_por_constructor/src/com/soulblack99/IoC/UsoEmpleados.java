package com.soulblack99.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Empleados juan = contexto.getBean("miEmpleado", Empleados.class);
		
		System.out.println(juan.getTareas());
		System.out.println(juan.getInforme());
		contexto.close();

	}

}
