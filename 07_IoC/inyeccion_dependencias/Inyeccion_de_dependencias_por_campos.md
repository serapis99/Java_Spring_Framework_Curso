# 📘 Inyección de Dependencias por Campos (Field / Property Injection)

## 📋 Descripción

La **inyección de dependencias por campos** consiste en **asignar valores o dependencias directamente a atributos de una clase**, normalmente mediante **métodos setter**.

Este tipo de inyección se utiliza principalmente para:

- valores de configuración
- datos simples (String, int, boolean, etc.)
- propiedades que **no forman parte del contrato de una interfaz**

---

## 🎯 Idea central

> No todo lo que necesita una clase pertenece a una interfaz.  
> Los **valores de configuración** se inyectan como **propiedades**, no como comportamientos.

---

## 🧠 Cuándo usar inyección de campos

- Para **datos simples** (email, nombre, rutas, flags)
- Para **configuración externa**
- Cuando el valor **no representa un comportamiento**
- Cuando no tiene sentido incluirlo en una interfaz

📌 No reemplaza a constructor o setter injection de dependencias,  
las **complementa**.

---

## 🧩 Ejemplo conceptual paso a paso

### 1️⃣ Agregar campos a la clase concreta

```java
private String email;
private String nombreEmpresa;
```

Estos campos:

- **no pertenecen a la interfaz**
- son detalles propios de la implementación

---

### 2️⃣ Crear getters y setters

```java
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
```

📌 **Regla clave de JavaBeans**  
Spring reconoce propiedades eliminando `set` y usando la primera letra en minúscula:

|Setter|Propiedad|
|---|---|
|setEmail|email|
|setNombreEmpresa|nombreEmpresa|

---

### 3️⃣ Inyección desde XML con `property`

```xml
<bean id="miSecretaria" class="com.soulblack99.IoC.SecretarioEmpleado">

    <!-- Inyección de dependencia -->
    <property name="informeNuevo" ref="miInforme"/>

    <!-- Inyección de valores -->
    <property name="email" value="soulblack99@gmail.com"/>
    <property name="nombreEmpresa" value="El Rey del mundo"/>

</bean>
```

📌 Diferencia clave:

- `ref` → inyecta **otro bean**
- `value` → inyecta **un valor literal**

---

## 🧠 Relación con interfaces

La interfaz `Empleados` **no conoce** estos campos:

```java
public interface Empleados {
    String getTareas();
    String getInforme();
}
```

Esto es **correcto** porque:

- las interfaces definen **comportamiento**
- los campos representan **configuración interna**
    
---

## 🔎 Acceso a los campos inyectados

### Opción 1️⃣ Pedir la clase concreta

```java
SecretarioEmpleado juan =
    contexto.getBean("miSecretaria", SecretarioEmpleado.class);

System.out.println(juan.getNombreEmpresa());
System.out.println(juan.getEmail());
```

---

### Opción 2️⃣ Casting desde la interfaz

```java
Empleados juan = contexto.getBean("miSecretaria", Empleados.class);

SecretarioEmpleado juan2 = (SecretarioEmpleado) juan;

System.out.println(juan2.getNombreEmpresa());
System.out.println(juan2.getEmail());
```

📌 Esto es válido cuando:

- sabes qué implementación estás usando
- necesitas acceder a detalles específicos

---

## ⚠️ Advertencias importantes

- Los campos **no están garantizados** si no se inyectan
- El objeto puede existir en estado incompleto
- No es ideal para dependencias críticas
- No debe usarse para lógica principal

---

## 🧠 20% Pareto (lo esencial)

- La inyección de campos sirve para **configuración**
- Usa `property` en la configuración
- `ref` → objetos
- `value` → valores simples
- No todo debe ir en la interfaz
    
---

## ✍️ Resumen

🌱 La **inyección de dependencias por campos** permite asignar valores y configuraciones a una clase sin modificar su interfaz ni su constructor.  
Es ideal para datos simples y detalles de implementación, complementando la inyección por constructor y por método en un diseño flexible y desacoplado.
