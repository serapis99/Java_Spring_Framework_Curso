# Historia de Spring Framework

## 📋 Descripción

La historia de **Spring Framework** surge como respuesta a la **complejidad del desarrollo empresarial en Java** a finales de los años 90 e inicios de los 2000.  
Spring aparece como una alternativa más simple y flexible frente al modelo dominante de [[J2EE]] y [[EJB]], y termina influyendo directamente en la evolución del propio estándar Java empresarial.

---

## 🕰️ Contexto inicial: J2EE

En **1999**, Sun Microsystems lanza **J2EE (Java 2 Platform, Enterprise Edition)**, una **especificación** destinada a estandarizar el desarrollo de aplicaciones empresariales en Java.

J2EE definía:
- qué componentes debía tener una aplicación
- qué servicios debía ofrecer el servidor (seguridad, transacciones, escalabilidad)

📌 J2EE indicaba **qué debía existir**, pero no **cómo debía usarse de forma simple**.

---

## 🧱 EJB: la pieza más problemática

Dentro de J2EE, **EJB (Enterprise JavaBeans)** se convirtió en el modelo central para la lógica empresarial.

Aunque resolvía problemas reales, EJB:
- era pesado
- requería mucha configuración
- acoplaba el código al servidor
- dificultaba las pruebas
- hacía costosas las actualizaciones

Cada nueva versión de EJB aumentaba la **complejidad accidental** del desarrollo.

---

## 🌱 El punto de quiebre (2002)

En **2002**, **Rod Johnson** publica el libro:

> *Expert One-on-One J2EE Design and Development*

En él demuestra que:
- muchas aplicaciones no necesitaban EJB
- el estándar había sobrecomplicado el desarrollo
- era posible construir aplicaciones empresariales usando objetos Java simples

De estas ideas nace **Spring Framework**.

---

## 🌼 Nacimiento de Spring (2004)

En **2004** se lanza oficialmente **Spring Framework 1.0**.

Spring propone:
- simplicidad frente a rigidez
- desacoplamiento frente a dependencia del servidor
- frameworks que se adapten al código, no al revés

Spring no rompe con Java, pero **cuestiona el modelo pesado de J2EE/EJB**.

---

## 🚀 Adopción en la industria

Spring es adoptado rápidamente porque:
- reduce complejidad
- facilita el mantenimiento
- mejora la experiencia del desarrollador
- permite evolucionar sistemas existentes sin reescribirlos

Cuando Java EE comienza a simplificarse, **Spring ya estaba ampliamente establecido en producción**.

---

## 🔄 Impacto en Java empresarial

Con el tiempo:
- Java EE adopta ideas de Spring
- EJB se simplifica (EJB 3)
- se introducen anotaciones y menor configuración

📌 No fue Spring quien siguió al estándar,  
📌 fue el estándar quien **aprendió de Spring**.

Más adelante:
- J2EE → Java EE
- Java EE → [[Jakarta EE]]

---

## 🧠 20% Pareto histórico (lo imprescindible)

- J2EE intentó ordenar el desarrollo empresarial
- EJB llevó la complejidad demasiado lejos
- Spring nació como reacción pragmática
- Su éxito real en producción influyó en el estándar
- La simplicidad validada por uso ganó frente al diseño rígido

👉 Este patrón se repite constantemente en la historia del software.
