# Inyección de Dependencias por Constructor en Spring

## 📋 Descripción

La **inyección de dependencias por constructor** es un patrón donde una clase recibe sus dependencias obligatorias a través del constructor en el momento de su creación.

Esto garantiza que:

- El objeto nunca exista en estado inválido.
- Todas sus dependencias estén disponibles desde el inicio.
- El diseño sea más claro y explícito.
    
En Spring, el contenedor IoC se encarga de:

- Crear los objetos.
- Resolver sus dependencias.
- Pasarlas automáticamente al constructor.
    

---

## 🎯 Problema que resuelve

Sin inyección por constructor:

- La clase puede quedar en estado inconsistente.
- Se puede olvidar asignar una dependencia.
- El código depende directamente de implementaciones concretas.
    

Con constructor injection:

- Las dependencias obligatorias se hacen explícitas.
- Se favorece la programación contra interfaces.
- Se mejora la testabilidad.
    
---

## 💡 Idea central

> Si una clase no puede funcionar sin una dependencia, debe recibirla en el constructor.

Esto convierte al constructor en el punto formal del contrato de inicialización.

---

## 🔎 Desarrollo

## 🔹 Paso 1: Definir la interfaz principal

Primero definimos el contrato base de nuestros empleados.

```java
public interface Empleados {

    String getTareas();
    String getInforme();
}
```

Aquí definimos el comportamiento común.

---

## 🔹 Paso 2: Crear la interfaz de la dependencia

```java
public interface CreacionInformes {

    String getInforme();
}
```

Esta es la dependencia que será inyectada.

---

## 🔹 Paso 3: Implementar la dependencia

```java
public class Informes implements CreacionInformes {

    @Override
    public String getInforme() {
        return "Informe generado correctamente.";
    }
}
```

Aquí tenemos una implementación concreta.

---

## 🔹 Paso 4: Implementar la clase que recibe la dependencia

```java
public class DirectorEmpleado implements Empleados {

    private final CreacionInformes informe;

    public DirectorEmpleado(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Gestionar la plantilla de empleados.";
    }

    @Override
    public String getInforme() {
        return "Informe del director: " + informe.getInforme();
    }
}
```

Puntos importantes:

- La dependencia es `final` → no puede cambiar después de creada.
    
- El constructor es el único punto de inyección.
    
- La clase depende de una abstracción, no de una implementación concreta.
    

---

## 🔹 Paso 5: Configuración en Spring (XML)

```xml
<bean id="miInforme" class="com.soulblack99.IoC.Informes"/>

<bean id="miEmpleado" class="com.soulblack99.IoC.DirectorEmpleado">
    <constructor-arg ref="miInforme"/>
</bean>
```

Spring:

1. Crea el bean `miInforme`.
2. Crea `miEmpleado`.
3. Inyecta `miInforme` en el constructor.
    

El XML no hace la inyección manualmente.  
Solo le indica al contenedor cómo resolver dependencias.

---

## 🔹 Alternativa moderna (Spring con anotaciones)

Hoy en día es más común usar:

```java
@Component
public class DirectorEmpleado implements Empleados {

    private final CreacionInformes informe;

    @Autowired
    public DirectorEmpleado(CreacionInformes informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Gestionar la plantilla.";
    }

    @Override
    public String getInforme() {
        return informe.getInforme();
    }
}
```

En Spring moderno, si solo existe un constructor, `@Autowired` puede omitirse.

---

## 🧠 Buenas prácticas

1. Usa constructor injection para dependencias obligatorias.
2. Declara las dependencias como `final`.
3. Programa contra interfaces.
4. Evita inyección por campos (field injection).
5. Mantén el constructor simple y claro.
    

---

## 🧠 20% Pareto (lo imprescindible)

Domina esto:

- El constructor define dependencias obligatorias.
- Spring resuelve e inyecta automáticamente.
- La clase no crea sus dependencias.
- Se depende de interfaces, no de implementaciones.
- Constructor injection es la forma más segura de inyección.
    

---

## 🤔 Reflexión (con respuestas)

**1. ¿Por qué la dependencia debe ser final?**  
Porque no debe cambiar después de creada la clase.

**2. ¿Qué problema tiene crear la dependencia con `new` dentro de la clase?**  
Rompe el principio de inversión de dependencias.

**3. ¿Puede existir el objeto sin la dependencia si usamos constructor injection?**  
No, el constructor obliga a recibirla.

**4. ¿Por qué es mejor que field injection?**  
Porque hace explícitas las dependencias y mejora la testabilidad.

---

## ✍️ Resumen

La inyección por constructor garantiza que los objetos:

- Se creen completamente válidos.
- Expresen claramente sus dependencias.
- Sean más fáciles de probar.
- Cumplan con principios SOLID.
    

Es la forma más recomendada en Spring cuando las dependencias son obligatorias y estructurales.