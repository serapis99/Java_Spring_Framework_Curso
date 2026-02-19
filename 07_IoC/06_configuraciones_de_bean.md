# Configuración de Beans en Spring

## 📋 Descripción

Spring permite definir **cómo se crean, configuran y conectan los objetos** (*beans*) mediante distintos mecanismos de configuración.

Estos mecanismos entregan instrucciones al **contenedor IoC**, indicando:
- qué objetos deben existir
- cómo se relacionan entre sí
- cómo se gestiona su ciclo de vida

Spring ofrece **tres formas principales de configuración**, todas equivalentes en capacidad, pero distintas en estilo y uso.

---

## 💡 Idea central

> No importa *cómo* se defina un bean,  
> sino que el **contenedor IoC** sea quien controle su creación y relaciones.

Las tres formas de configuración existen para adaptarse a distintos contextos, no porque una sea “mejor” que otra en términos funcionales.

---

## 🧩 1. Configuración mediante anotaciones

Es la forma **más común y moderna**.

Se utilizan anotaciones directamente sobre clases o métodos para indicar que deben ser gestionados por Spring.

Ejemplos frecuentes:
- `@Component`
- `@Service`
- `@Repository`
- `@Controller`

📌 Características:
- mínima configuración externa
- código más conciso
- ideal para aplicaciones modernas

Spring detecta estos componentes automáticamente mediante **escaneo de clases**.

---

## 🧩 2. Configuración mediante Java Config

Utiliza clases Java normales anotadas con `@Configuration`.

Dentro de ellas, los beans se declaran con métodos anotados con `@Bean`.

📌 Características:
- control explícito sobre la creación del objeto
- permite lógica de construcción más compleja
- sigue siendo tipado y seguro en tiempo de compilación

Es similar a escribir instrucciones detalladas para armar cada componente.

---

## 🧩 3. Configuración mediante XML

Es el método **históricamente más antiguo**.

Los beans y sus relaciones se definen en archivos XML usando una sintaxis estructurada.

📌 Características:
- configuración totalmente externa al código
- más verboso
- hoy se usa poco, pero sigue siendo válido

Aún es útil en sistemas legacy o donde se requiere separar completamente código y configuración.

---

## 🔄 Qué tienen en común los tres métodos

Independientemente del mecanismo usado, todos permiten:

- definir qué beans existen
- inyectar dependencias
- configurar propiedades
- gestionar el ciclo de vida (creación y destrucción)

La **Inversión de Control (IoC)** es lo que hace posible esta flexibilidad.

---

## 🧠 20% Pareto (lo imprescindible)

- Spring ofrece **tres formas de configurar beans**
- Todas sirven para lo mismo: controlar objetos desde el contenedor
- Anotaciones → simplicidad
- Java Config → control
- XML → configuración externa
- IoC es el concepto que las unifica

Si entiendes esto, puedes leer cualquier proyecto Spring sin perderte.

---

## ✍️ Resumen

🌱 Spring permite configurar beans mediante anotaciones, Java Config o XML.  
Aunque difieren en estilo y nivel de control, los tres métodos existen para dar instrucciones al contenedor IoC sobre la creación, conexión y ciclo de vida de los objetos, permitiendo aplicaciones flexibles, organizadas y fácilmente configurables.