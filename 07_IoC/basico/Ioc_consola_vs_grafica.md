# Control del flujo e Inversión de Control

## 📋 Descripción

El **control del flujo de ejecución** define **quién decide qué se ejecuta y cuándo** dentro de una aplicación.

A lo largo del tiempo, este control ha evolucionado desde programas completamente secuenciales  
hasta frameworks modernos, dando origen a la **Inversión de Control (IoC)**.

Comprender este cambio explica por qué los frameworks *no se usan como librerías tradicionales*.

---

## 🧭 Modelo tradicional: aplicaciones de consola

En una aplicación de consola:

- el programador controla el flujo paso a paso
- las instrucciones se ejecutan de forma secuencial
- el código decide explícitamente:
  - qué clase se instancia
  - cuándo se llama
  - qué ocurre después

El programador actúa como el **director absoluto** del programa.

👉 Este modelo es simple, pero tiende a generar:
- alto acoplamiento
- código rígido
- dificultad para cambiar comportamientos

---

## 🖱️ Cambio de paradigma: interfaces gráficas (GUI)

Con la llegada de las interfaces gráficas:

- el flujo deja de ser secuencial
- el programa reacciona a **eventos**
- el programador ya no decide el orden de ejecución

En lugar de controlar el flujo, el desarrollador define:

- qué debe ocurrir **cuando** sucede un evento  
  (por ejemplo, un clic en un botón)

El framework:
- escucha los eventos
- decide cuándo ejecutar la lógica
- invoca el código del programador

Aquí aparece un mensaje implícito:

> *No controles el flujo, el sistema lo hará por ti*

---

## 🔄 Aparición temprana de Inversión de Control

Este modelo basado en eventos representa una **forma temprana de Inversión de Control (IoC)**:

- el control del flujo ya no pertenece al programador
- pasa al framework
- el código del usuario solo **responde cuando es llamado**

Esto se resume en el [Principio de Hollywood](sale_de.md):

> *No nos llames, nosotros te llamamos*

---

## 🌱 Evolución hacia IoC moderno

Este enfoque no se quedó solo en las interfaces gráficas.

Frameworks modernos como Spring Framework amplían la idea:

- no solo controlan el flujo
- también controlan:
  - la creación de objetos
  - la gestión de dependencias
  - el ciclo de vida de los componentes

Spring **no inventó IoC**, pero:

- lo sistematiza
- lo formaliza
- lo implementa mediante la **Inyección de Dependencias (DI)**

---

## 🧠 20% Pareto (lo esencial)

Si recuerdas esto, entiendes el origen de IoC:

- En consola, el programador controla el flujo
- En frameworks, el sistema controla el flujo
- Las GUIs introducen IoC a través de eventos
- Spring extiende IoC al control de objetos y dependencias

Esto explica **por qué los frameworks funcionan como funcionan**.

---

## ✍️ Resumen

🌿 La **Inversión de Control** surge cuando el control del flujo de ejecución deja de estar en manos del programador y pasa al framework.  
Desde aplicaciones gráficas basadas en eventos hasta frameworks como Spring, este cambio permite sistemas más flexibles, desacoplados y mantenibles.
