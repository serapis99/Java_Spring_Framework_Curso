# Inyección de Dependencias (Dependency Injection)

## 📘 Descripción

La **Inyección de Dependencias (Dependency Injection, DI)** es un patrón de diseño que consiste en **proveer a un objeto las dependencias que necesita desde el exterior**, en lugar de permitir que las cree por sí mismo.

Una *dependencia* es cualquier recurso u objeto que otro objeto necesita para cumplir su función.

La DI busca **separar la responsabilidad de usar una dependencia** de la **responsabilidad de crearla**.

---

## 🎯 Problema que aborda

En diseños tradicionales:

- los objetos crean directamente sus dependencias
- las clases conocen implementaciones concretas
- el sistema se vuelve rígido
- los cambios se propagan
- las pruebas se dificultan

Este enfoque genera **alto acoplamiento**, donde los cambios en una parte afectan a muchas otras.

---

## 💡 Idea central

> Un objeto **no debe saber cómo se construyen** las cosas que usa,  
> solo **qué necesita para funcionar**.

La creación de dependencias se delega a un componente externo.

---

## 🔄 Relación con Inversión de Control (IoC)

- **IoC** es el principio arquitectónico
- **DI** es una forma concreta de aplicarlo

Con DI:
- el flujo de control no está en el objeto
- el objeto no decide qué crear
- el control se invierte hacia el exterior

---

## 🧠 Qué NO es Inyección de Dependencias

- No es un framework
- No es exclusivo de ningún lenguaje
- No es solo “pasar objetos por parámetros”
- No es magia automática

DI es **una decisión de diseño**, no una herramienta específica.

---

## 🧩 Tipos conceptuales de Inyección de Dependencias

### 1️⃣ Inyección por constructor

Las dependencias se entregan al crear el objeto.

- garantiza objetos válidos desde su nacimiento
- las dependencias son obligatorias
- favorece la inmutabilidad

📌 Es la forma **conceptualmente más fuerte** de DI.

---

### 2️⃣ Inyección por métodos (setters)

Las dependencias se asignan después de crear el objeto.

- permite dependencias opcionales
- habilita cambios posteriores
- requiere mayor control del estado del objeto

---

### 3️⃣ Inyección directa (por atributo/campo)

Las dependencias se asignan directamente al objeto.

- es la menos explícita
- oculta dependencias reales
- puede dificultar comprensión y pruebas

---

## 🔓 Beneficios principales

- **Bajo acoplamiento**
- **Alta cohesión**
- **Facilidad de cambio**
- **Mejor testabilidad**
- **Diseños más flexibles**
- **Mayor claridad de responsabilidades**

---

## ⚠️ Riesgos y malos usos

- exceso de abstracciones innecesarias
- configuraciones complejas sin justificación
- dependencia excesiva de contenedores
- pérdida de claridad si se abusa del patrón

📌 DI no reemplaza el buen diseño, lo exige.

---

## 🧠 Relación con otros principios

- **SRP**: separa creación de uso
- **OCP**: permite extender sin modificar
- **DIP**: favorece depender de abstracciones
- **Hollywood Principle**: “No nos llames, nosotros te llamamos”

---

## 📝 Idea clave

> La Inyección de Dependencias no elimina dependencias,  
> **hace explícita su gestión** y las saca del código de negocio.

---

## ❓ Pregunta clave

**¿Quién debería decidir qué implementación usar?**  
No el objeto que la consume.

---

## ✍️ Resumen

🌱 La **Inyección de Dependencias** es un patrón que delega la creación y provisión de dependencias a un componente externo, reduciendo acoplamiento y aumentando la flexibilidad del sistema. Es una aplicación práctica de la Inversión de Control y una base fundamental del diseño de software moderno.