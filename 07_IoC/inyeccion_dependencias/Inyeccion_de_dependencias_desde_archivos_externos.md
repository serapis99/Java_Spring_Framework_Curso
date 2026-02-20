# 📘 Inyección de Dependencias desde Archivos Externos

## 📋 Descripción

En aplicaciones reales, **los valores de configuración no deben estar escritos directamente en el código ni en el XML**. Datos como correos, nombres de empresa, credenciales o rutas pueden cambiar entre entornos (desarrollo, pruebas, producción).

Para resolver esto, se utiliza un **archivo externo de propiedades**, desde el cual el contenedor de IoC leerá los valores y los **inyectará automáticamente** en los beans.

---

## 🎯 Idea central

> El código define **qué necesita una clase**, pero los valores reales se definen **fuera del código**.

Esto permite:

- cambiar configuraciones sin recompilar
- reutilizar el mismo código en distintos entornos 
- mantener el código limpio y desacoplado
    
---

## 🧩 Paso 1: Crear el archivo de propiedades

Se crea un archivo externo, por ejemplo:

```txt
datosEmpresa.propiedades
```

Con los valores de configuración:

```txt
email=soulblack99@gmail.com
nombreEmpresa=El Rey del mundo
```

📌 Este archivo suele ubicarse en la **ruta raíz del classpath** del proyecto.

---

## 🧩 Paso 2: Cargar el archivo en la configuración XML

Para que el contenedor pueda leer el archivo, se debe registrar el cargador de propiedades:

```xml
<context:property-placeholder location="classpath:datosEmpresa.propiedades"/>
```

📌 Con esto, Spring:

- lee el archivo
- registra cada par `clave=valor` 
- los deja disponibles para inyección
    

---

## 🧩 Paso 3: Inyectar los valores en el bean

Los valores se usan mediante la sintaxis:

```text
${nombre_propiedad}
```

Ejemplo completo:

```xml
<bean id="miSecretaria" class="com.soulblack99.IoC.SecretarioEmpleado">

    <property name="email" value="${email}"/>
    <property name="nombreEmpresa" value="${nombreEmpresa}"/>

</bean>
```

📌 El contenedor:

1. busca la propiedad
2. obtiene su valor 
3. llama automáticamente al setter correspondiente
    
---

## 🧠 Qué ocurre internamente

1. Spring crea el bean
2. Detecta las propiedades configuradas
3. Resuelve `${email}` y `${nombreEmpresa}`
4. Ejecuta:
    - `setEmail(valor)`
    - `setNombreEmpresa(valor)`
    - 
La clase **no sabe** de dónde vienen los datos.

---

## 🧠 Relación con la inyección de campos

Esta técnica es una **extensión de la inyección por método (setter)**:

- requiere setters
- no afecta a la interfaz
- se usa para configuración
    
No sustituye la inyección por constructor para dependencias críticas.

---

## ⚠️ Buenas prácticas

- Usar archivos externos para:
    
    - configuración
    - datos de entorno
        
- No usarlos para lógica de negocio
- No incluir datos sensibles en repositorios públicos
    
---

## ✍️ Resumen

🌱 La inyección de dependencias desde archivos externos permite separar completamente la **configuración** del **código**, haciendo que las aplicaciones sean más flexibles, mantenibles y preparadas para distintos entornos.