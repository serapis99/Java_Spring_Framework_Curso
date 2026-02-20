# Principio de Hollywood (IoC)

## 📋 Descripción

El **Principio de Hollywood** se resume en la frase:

> *“No nos llames, nosotros te llamamos”*

Describe un modelo en el que un componente **no toma la iniciativa de llamar al sistema principal**.  
En su lugar, es el sistema quien decide **cuándo y cómo invocar a sus componentes**.

Este principio es una **manifestación práctica** de la Inversión de Control (IoC) aplicada al **flujo de ejecución**.

---

## 💡 Idea central

> Los componentes no controlan el flujo;  
> el framework decide cuándo deben participar.

Esto invierte la relación tradicional donde el código de la aplicación coordinaba toda la ejecución.

---

## 🔄 Relación con IoC

En un diseño tradicional:

- el código llama a librerías
- el programador controla el orden de ejecución

Con el Principio de Hollywood:

- el framework controla el flujo
- el código del usuario **responde cuando es invocado**

👉 Esto es IoC en su forma más intuitiva.

---

## 🔗 Aplicación en Spring

En el contexto de Spring Framework:

- los objetos **no se autogestionan**
- no deciden cuándo ejecutarse
- no coordinan el flujo global

Spring:

- controla el flujo de la aplicación
- crea los objetos
- decide cuándo activarlos
- los conecta cuando son necesarios

Esto demuestra que IoC no solo trata de **crear objetos**,  
sino también de **controlar cuándo participan**.

---

## 🎬 Analogía: Hollywood

En los castings tradicionales:

- los actores llamaban constantemente para saber si habían sido seleccionados
- esto generaba desorden y trabajo innecesario

Con el principio:

> *“No nos llames, nosotros te llamamos”*

- la organización contacta solo a los actores elegidos
- el flujo queda centralizado y controlado

En Spring:

- los objetos son los actores
- el framework es el agente de casting
- los componentes no preguntan
- el sistema los invoca cuando corresponde

---

## 🧠 20% Pareto (lo esencial)

Si recuerdas esto, entiendes el principio:

- El Principio de Hollywood significa **no controlar el flujo**
- El framework decide cuándo ejecutar cada componente
- Los objetos reaccionan, no coordinan
- Reduce el acoplamiento
- Hace los sistemas más predecibles

Esto explica **por qué los frameworks funcionan como funcionan**.

---

## 🤔 Reflexión (con respuestas)

**¿Qué problema evita este principio?**  
Evita que los componentes dependan del flujo global y llamen al sistema principal.

**¿Por qué reduce el acoplamiento?**  
Porque los componentes no conocen ni controlan la ejecución completa.

**¿Es exclusivo de Spring?**  
No. Aparece en callbacks, listeners, frameworks web y sistemas orientados a eventos.

**¿Qué relación tiene con IoC?**  
Es una expresión directa de IoC aplicada al flujo de ejecución.

---

## ✍️ Resumen

🌿 El **Principio de Hollywood** establece que los componentes no deben decidir cuándo participan en un sistema.  
Al centralizar el control del flujo en el framework, se logra una arquitectura más limpia, desacoplada y fácil de mantener.  
En **Spring**, este principio es clave para entender cómo y por qué el framework invoca tu código.