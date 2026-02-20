# 📋 Descripción

La inyección de dependencias por método (setter injection) consiste en proporcionar una dependencia después de crear el objeto, mediante un método público (setter).

El contenedor IoC crea primero el objeto y luego invoca automáticamente el método setter para inyectar la dependencia.

Este enfoque es útil cuando la dependencia es opcional o configurable.

---

# 🎯 Idea central

La clase define cómo recibir la dependencia (mediante un setter), pero no cuándo ni cuál implementación usar.

El objeto puede existir sin la dependencia, pero necesita ser configurado antes de utilizarse correctamente.

---

# 🧠 Características clave

- La dependencia no es obligatoria al momento de crear el objeto
- Permite cambiar dependencias en tiempo de configuración
- Es más flexible que la inyección por constructor
- Es menos segura porque el objeto puede quedar parcialmente configurado
- Puede provocar errores si se usa antes de inyectar la dependencia
    
---

# 🧩 Ejemplo conceptual

## 1️⃣ Abstracción

```java
public interface CreacionInformes {
    String getInforme();
}
```

---

## 2️⃣ Implementación

```java
public class Informes implements CreacionInformes {

    @Override
    public String getInforme() {
        return "Esta es la presentación del informe";
    }
}
```

---

## 3️⃣ Clase preparada para inyección por método

```java
public class SecretarioEmpleado implements Empleados {

    private CreacionInformes informe;

    public void setInforme(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getInforme() {
        return "Informe de la secretaria: " + informe.getInforme();
    }
}
```

📌 El setter es el punto de inyección.  
📌 El objeto se crea primero y luego se configura.  
📌 Si no se inyecta la dependencia, puede producirse un `NullPointerException`.

---

## 🔧 Configuración externa (ejemplo XML)

```xml
<bean id="miInforme" class="com.soulblack99.IoC.Informes"/>

<bean id="miSecretaria" class="com.soulblack99.IoC.SecretarioEmpleado">
    <property name="informe" ref="miInforme"/>
</bean>
```

📌 `property` invoca automáticamente el método `setInforme(...)`.

---

# ⚠️ Cuándo usar setter injection

- La dependencia es opcional
- Puede cambiar según configuración
- Se necesita flexibilidad
- Hay muchas dependencias y algunas no son obligatorias

---

# ✍️ Resumen

🌱 La inyección por método permite recibir dependencias después de crear el objeto, ofreciendo mayor flexibilidad.

Sin embargo, el objeto puede existir en un estado incompleto hasta que la dependencia sea inyectada, por lo que debe usarse principalmente cuando la dependencia no sea estrictamente obligatoria.