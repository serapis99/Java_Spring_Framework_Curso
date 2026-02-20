# Spring File JAR

## 📋 Descripción

Cuando un proyecto **no utiliza gestores de dependencias** como **Maven** o **Gradle**,  
no existe un mecanismo automático para descargar todas las librerías necesarias del **Spring Framework**.

En estos casos, es necesario descargar **manualmente** cada módulo desde **Maven Central**,  
revisando la carpeta correspondiente y seleccionando **únicamente los archivos requeridos para la ejecución real** del proyecto.

Esta guía describe:

- qué archivos JAR son **obligatorios**
- cuáles **no son necesarios** en tiempo de ejecución
- qué módulos componen Spring Framework
- **dónde conseguirlos exactamente** (rutas directas)

---

## 📦 Tipos de archivos JAR en Maven Central

En Maven Central, cada módulo de Spring suele ofrecer **tres tipos de JAR**:

| Archivo                | ¿Se necesita en ejecución? | ¿Para qué sirve? |
| ---------------------- | -------------------------- | ---------------- |
| **módulo.jar**         | ✅ **Sí (obligatorio)**     | Código ejecutable del módulo. |
| **módulo-sources.jar** | ❌ No                      | Código fuente para inspección en el IDE. |
| **módulo-javadoc.jar** | ❌ No                      | Documentación offline. |

📌 **Regla fundamental**

> Para ejecutar Spring, **solo es obligatorio el JAR principal** (`módulo.jar`).

Los archivos `sources` y `javadoc` son opcionales y solo aportan comodidad en el desarrollo.

---

## 📦 Módulos de Spring Framework (descarga manual)

En proyectos sin Maven ni Gradle, **todos los módulos deben descargarse manualmente** desde Maven Central.

> ⚠️ **Los enlaces se preservan exactamente como referencia operativa**

| Librería | Función | Repositorio Maven Central |
|--------|--------|---------------------------|
| spring-core | Núcleo de Spring | https://repo1.maven.org/maven2/org/springframework/spring-core/ |
| spring-beans | Beans e IoC | https://repo1.maven.org/maven2/org/springframework/spring-beans/ |
| spring-context | Contenedor principal | https://repo1.maven.org/maven2/org/springframework/spring-context/ |
| spring-context-support | Integraciones | https://repo1.maven.org/maven2/org/springframework/spring-context-support/ |
| spring-context-indexer | Optimización de escaneo | https://repo1.maven.org/maven2/org/springframework/spring-context-indexer/ |
| spring-expression | SpEL | https://repo1.maven.org/maven2/org/springframework/spring-expression/ |
| spring-instrument | Instrumentación | https://repo1.maven.org/maven2/org/springframework/spring-instrument/ |
| spring-jcl | Logging | https://repo1.maven.org/maven2/org/springframework/spring-jcl/ |
| spring-aop | Programación orientada a aspectos | https://repo1.maven.org/maven2/org/springframework/spring-aop/ |
| spring-aspects | Integración con AspectJ | https://repo1.maven.org/maven2/org/springframework/spring-aspects/ |
| spring-jdbc | Acceso a datos JDBC | https://repo1.maven.org/maven2/org/springframework/spring-jdbc/ |
| spring-tx | Gestión de transacciones | https://repo1.maven.org/maven2/org/springframework/spring-tx/ |
| spring-orm | Integración ORM | https://repo1.maven.org/maven2/org/springframework/spring-orm/ |
| spring-oxm | Object/XML Mapping | https://repo1.maven.org/maven2/org/springframework/spring-oxm/ |
| spring-jms | Java Message Service | https://repo1.maven.org/maven2/org/springframework/spring-jms/ |
| spring-messaging | Mensajería | https://repo1.maven.org/maven2/org/springframework/spring-messaging/ |
| spring-web | Web y REST | https://repo1.maven.org/maven2/org/springframework/spring-web/ |
| spring-webmvc | Spring MVC | https://repo1.maven.org/maven2/org/springframework/spring-webmvc/ |
| spring-webflux | Programación reactiva | https://repo1.maven.org/maven2/org/springframework/spring-webflux/ |
| spring-websocket | WebSocket | https://repo1.maven.org/maven2/org/springframework/spring-websocket/ |
| spring-test | Testing | https://repo1.maven.org/maven2/org/springframework/spring-test/ |

---

## 🧠 Pareto de aprendizaje (qué entender primero)

Para comprender Spring Framework de forma sólida, los módulos más importantes son:

1. **spring-core**
2. **spring-beans**
3. **spring-context**
4. **spring-aop**
5. **spring-web / spring-webmvc**
6. **spring-tx**

📌 Dominar estos módulos permite entender aproximadamente el **80% del funcionamiento real de Spring**.  
El resto corresponde a casos específicos o necesidades de especialización.

---

## ⚠️ Advertencia importante

Gestionar Spring sin Maven o Gradle:

- incrementa la complejidad
- facilita errores de versiones incompatibles
- dificulta el mantenimiento a largo plazo

Este enfoque es **muy útil para aprendizaje**, análisis interno y entornos controlados,  
pero **no se recomienda para proyectos de producción**.
