# Inversión de Control (IoC)

## 📋 Descripción

La **Inversión de Control (IoC)** es un principio de diseño en el que el programador  
**deja de crear y coordinar manualmente los objetos** de una aplicación.

En su lugar, esa responsabilidad se delega a un Framework como Spring.
Con IoC, el código:

- deja de decidir **cómo** se crean los objetos
- se enfoca únicamente en **qué necesita**

---

## 🎯 Problema que resuelve

En el modelo tradicional (sin IoC):

- las clases crean directamente sus dependencias
- el código conoce implementaciones concretas
- cambiar comportamientos requiere modificar muchas clases
- las pruebas se vuelven complejas

Esto produce:

- **alto acoplamiento**
- sistemas rígidos
- bajo margen de evolución

IoC surge para **invertir esta responsabilidad** y reducir esas dependencias.

---

## 💡 Idea central

> El código no debe crear ni conectar sus dependencias;  
> esa responsabilidad se delega a un contenedor externo.

En Spring, este contenedor es el **`ApplicationContext`**, que administra los objetos de la aplicación, llamados **beans**.

El contenedor:

- crea los objetos
- los configura
- los conecta entre sí
- gestiona su ciclo de vida

---

## 🧠 20% Pareto (lo imprescindible)

Si recuerdas esto, entiendes IoC:

- IoC significa **ceder el control**
- El framework crea y conecta los objetos
- El código solo declara **qué necesita**
- Esto reduce el acoplamiento
- Facilita cambios, pruebas y mantenimiento

El resto son detalles de implementación.

---

## 🔗 Ejemplo conceptual

Un componente necesita un objeto de tipo `Empleado`.

El código **no decide** si es:

- `Jefe`
- `Director`
- `Secretario`

Spring decide qué implementación entregar según:

- la configuración
- el contexto de la aplicación

👉 El componente solo conoce el **contrato**, no la implementación concreta.

---

## 🧠 Analogía explicativa

Imagina un restaurante:

- ❌ Modelo tradicional: el programador cocina todo
- ✔️ Con IoC: el framework es la cocina

El desarrollador:

- pide un plato
- no se preocupa por los ingredientes ni la preparación

El **contenedor IoC** funciona como esa cocina que entrega los objetos listos.

---

## 🔗 Relación con Inyección de Dependencias

La **Inyección de Dependencias (DI)** es la **forma práctica** de aplicar IoC.

- IoC → principio
- DI → mecanismo

Spring implementa IoC principalmente a través de DI:

- por constructor
- por setter
- por campo

---

## 🤔 Reflexión (con respuestas)

**¿Por qué crear objetos directamente aumenta el acoplamiento?**  
Porque el código queda ligado a implementaciones concretas.

**¿Por qué IoC facilita las pruebas?**  
Porque las dependencias pueden sustituirse por implementaciones simuladas.

**¿IoC es exclusivo de Spring?**  
No. Es un principio general aplicable en muchos frameworks.

**¿Spring obliga a usar IoC?**  
No, pero su diseño está orientado a que lo adoptes de forma natural.

---

## ✍️ Resumen

🌿 La **Inversión de Control (IoC)** es un principio de diseño donde un framework asume la responsabilidad de crear y conectar los objetos de una aplicación.  
Al delegar esta tarea al contenedor, el código queda más desacoplado, flexible y fácil de probar.  
En **Spring**, IoC es la base sobre la que se construye todo el framework.