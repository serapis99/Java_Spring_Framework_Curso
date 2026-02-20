# 🧩 Singleton vs Prototype en Spring (demostración práctica)

## 📋 Descripción

Por defecto, **Spring crea los beans con alcance (scope) `singleton`**. Esto significa que el contenedor **crea una sola instancia** del objeto y **la reutiliza cada vez que se solicita**.

Este comportamiento puede verificarse fácilmente imprimiendo la referencia del objeto en memoria. A partir de esta observación, Spring permite cambiar explícitamente el alcance del bean a `prototype`, donde **cada solicitud genera una nueva instancia**.

Esta guía explica:

- cómo comprobar el comportamiento singleton
- cómo cambiar el alcance a prototype 
- qué está ocurriendo realmente en el contenedor IoC
    
---

## 🟦 1. Comprobando el comportamiento por defecto (Singleton)

Spring usa `singleton` como alcance predeterminado. Para validarlo, solicitamos **dos veces el mismo bean** desde el contenedor:

```java
ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext2.xml");

Empleados juan = contexto.getBean("miSecretaria", Empleados.class);
Empleados pedro = contexto.getBean("miSecretaria", Empleados.class);

System.out.println(juan);
System.out.println(pedro);
```

Salida en consola:

```terminal
com.soulblack99.IoC.SecretarioEmpleado@3cce57c7
com.soulblack99.IoC.SecretarioEmpleado@3cce57c7
```

📌 **Interpretación**

- Ambas referencias apuntan a la **misma posición en memoria**
- Spring creó **una sola instancia** 
- Cada llamada a `getBean()` devuelve **el mismo objeto**
    
---

## 🟩 2. Singleton explícito (comportamiento por defecto)

Aunque no es necesario indicarlo, declarar explícitamente el scope ayuda a entender qué está pasando:

```xml
<bean id="miSecretaria"
      class="com.soulblack99.IoC.SecretarioEmpleado"
      scope="singleton">

    <property name="informeNuevo" ref="miInforme" />

</bean>
```

📌 Esto es **equivalente** a no declarar ningún `scope`.

---

## 🟨 3. Cambiando el alcance a Prototype

Para que Spring cree **una nueva instancia cada vez que se solicite el bean**, se usa `scope="prototype"`:

```xml
<bean id="miSecretaria"
      class="com.soulblack99.IoC.SecretarioEmpleado"
      scope="prototype">

    <property name="informeNuevo" ref="miInforme" />

</bean>
```

Al ejecutar el mismo código Java:

```terminal
com.soulblack99.IoC.SecretarioEmpleado@3cce57c7
com.soulblack99.IoC.SecretarioEmpleado@1cf56a1c
```

📌 **Interpretación**

- Cada llamada a `getBean()` crea un **nuevo objeto**
- Las referencias en memoria son diferentes 
- El contenedor **no reutiliza instancias**
    

---

## 🧠 4. Qué está controlando Spring realmente

|Scope|¿Cuántas instancias?|¿Cuándo se crean?|¿Quién las gestiona?|
|---|---|---|---|
|singleton|Una|Al iniciar el contexto|Spring (ciclo completo)|
|prototype|Una por solicitud|Cada `getBean()`|Spring solo crea|

📌 En `prototype`, Spring **no gestiona la destrucción del objeto**.

---

## ⚠️ Idea clave

> **El scope no cambia la clase, cambia el contrato de creación.**

- `singleton` → compartir instancia
- `prototype` → crear instancias nuevas
    

Esto afecta directamente:

- uso de estado
- concurrencia 
- diseño de la aplicación
    
---

## ✍️ Resumen

🌱 Spring utiliza [[Singleton]] por defecto, lo que significa que todos los consumidores de un bean comparten la misma instancia. Este comportamiento puede verificarse comparando referencias en memoria.

Al cambiar el scope a [[prototype]], el contenedor crea un nuevo objeto por cada solicitud, delegando al desarrollador la responsabilidad de su gestión posterior.

Entender esta diferencia es clave para diseñar aplicaciones correctas y evitar errores de estado compartido.