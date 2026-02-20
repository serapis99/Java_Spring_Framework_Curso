# 🔄 Ciclo de vida de un Bean en Spring

Esta nota explica **qué ocurre desde que el contenedor Spring se inicia hasta que se apaga**, y cómo encajan en ese proceso los métodos **init** y **destroy**. El objetivo es comprender _el porqué_ de cada fase, no solo cómo configurarla.

---

## 🧭 Flujo general del ciclo de vida

Cuando trabajas con Spring, **los objetos no viven por sí solos**. Su existencia está controlada por el contenedor IoC, que sigue una secuencia bien definida:

1. Contenedor Spring iniciado
2. Instanciación del bean 
3. [inyeccion de dependencias](inyeccion_de_dependencias.md)
4. Procesado interno del bean 
5. Ejecución del método **init**
6. Bean listo para su uso 
7. Contenedor Spring apagado 
8. Ejecución del método **destroy**
    
📌 Los métodos `init` y `destroy` **no son automáticos**: tú decides si existen y cuándo deben ejecutarse mediante configuración.

---

## 🟢 Método `init`

### ¿Cuándo se ejecuta?

Después de que:

- el objeto ha sido creado
- **todas sus dependencias ya fueron inyectadas**
    
En este punto, el bean existe y está completo, pero **aún no se considera listo**.

### 🎯 Propósito del método `init`

El método `init` sirve para:

- preparar el bean antes de su uso real
- ejecutar lógica que **depende de otros beans ya inyectados**
- activar servicios de forma controlada (inicio retardado)
    
Ejemplos conceptuales:

- inicializar recursos internos    
- validar configuraciones
- arrancar procesos auxiliares
    
📌 No se usa para crear dependencias, sino para **preparar el estado final del objeto**.

---

## 🔴 Método `destroy`

### ¿Cuándo se ejecuta?

Cuando:

- el contenedor Spring se apaga
- se cierra explícitamente el contexto
    
### 🎯 Propósito del método `destroy`

El método `destroy` sirve para:

- liberar recursos
- cerrar conexiones (BD, archivos, sockets) 
- finalizar procesos abiertos por el bean
    
Ejemplos conceptuales:

- cerrar conexiones a base de datos
- detener hilos 
- limpiar buffers o caches
    
📌 Spring **no destruye el objeto sin avisar**: te da un punto exacto para cerrar correctamente.

---

## 🧪 Ejemplo conceptual

### 📌 Métodos definidos en la clase

```java
public void metodoInicial() {
    System.out.println("Aqui se ejecutan las tareas antes de que el bean este listo");
}

public void metodoFinal() {
    System.out.println("Aqui se ejecutan las tareas despues de destruir el bean");
}
```

Estos métodos **no pertenecen a ninguna interfaz especial**. Son métodos normales que Spring invocará por configuración.

---

### 📌 Configuración en XML

```xml
<bean id="miInforme" class="com.soulblack99.IoC.Informes" />

<bean id="miEmpleado" class="com.soulblack99.IoC.DirectorEmpleado"
      init-method="metodoInicial"
      destroy-method="metodoFinal">

    <constructor-arg ref="miInforme" />

</bean>
```

Aquí ocurre lo importante:

- Spring crea el bean
- inyecta `miInforme` 
- ejecuta `metodoInicial`
- deja el bean listo 
- al cerrar el contexto → ejecuta `metodoFinal`
    
---

### 📌 Uso desde el `main`

```java
ClassPathXmlApplicationContext contexto =
        new ClassPathXmlApplicationContext("applicationContext3.xml");

Empleados juan = contexto.getBean("miEmpleado", Empleados.class);
System.out.println(juan.getInforme());

contexto.close();
```

📌 La llamada a `contexto.close()` es clave: **sin ella, el método `destroy` no se ejecuta**.

---

## 🧠 Idea clave (20% Pareto)

- Spring controla **cuándo nace y cuándo muere un bean**
- `init` prepara el bean **después de inyectar dependencias** 
- `destroy` limpia recursos **antes de eliminarlo**
- No es magia: es control explícito del ciclo de vida
    
Entender esto significa entender que **Spring no solo crea objetos, los administra de principio a fin**.

---

## ✍️ Resumen

🌱 El ciclo de vida de un bean define cómo Spring gestiona sus objetos desde la creación hasta la destrucción. Los métodos `init` y `destroy` permiten ejecutar lógica controlada en momentos clave, garantizando objetos bien preparados y recursos correctamente liberados. Esto refuerza la idea central de IoC: _el contenedor gobierna el flujo, no los objetos_.