# Desacoplamiento (Loose Coupling)

## 📋 Descripción

El **desacoplamiento** es un principio de diseño que busca que las partes de un sistema  
**dependan lo menos posible entre sí**.

Un componente desacoplado:

- no conoce los detalles internos de otros componentes
- se comunica mediante **contratos claros** (interfaces)
- puede cambiar sin provocar efectos en cascada

Este principio es clave para construir software:

- mantenible
- flexible
- preparado para crecer con el tiempo

---

## 🎯 Problema que resuelve

En sistemas **altamente acoplados**:

- un cambio pequeño rompe muchas partes
- las pruebas requieren entornos complejos
- el mantenimiento se vuelve costoso
- el sistema se vuelve frágil con el tiempo

El desacoplamiento surge para:

- **limitar el impacto de los cambios**
- permitir evolución controlada
- reducir dependencias innecesarias

---

## 💡 Idea central

> Un componente debe depender de **abstracciones**,  
> no de **implementaciones concretas**.

Cuando el código depende de contratos y no de detalles:

- las implementaciones pueden cambiar
- los componentes pueden reemplazarse
- las pruebas se simplifican

---

## 🧠 20% Pareto (lo imprescindible)

Si entiendes esto, entiendes el desacoplamiento:

- Desacoplar es **reducir dependencias directas**
- Los componentes no deberían:
  - crearse entre sí
  - decidir qué implementación usar
- La comunicación se hace mediante **interfaces**
- El sistema se vuelve más:
  - flexible
  - testeable
  - mantenible

---

## 🔗 Relación con Spring

- gestiona la creación de objetos
- conecta componentes automáticamente
- separa lógica de negocio de infraestructura

Gracias a Spring:

- las clases no saben **quién las crea**
- solo declaran **qué necesitan**

Esto se relaciona directamente con:

- inversion de control (IoC)
- inyección de dependencias

---

## 🧠 Ejemplo conceptual

Un módulo necesita enviar notificaciones.

### ❌ Sistema acoplado

- decide qué servicio usar
- sabe cómo se construye
- debe cambiar si la implementación cambia

### ✔️ Sistema desacoplado

- solo expresa: “necesito enviar una notificación”
- otra parte decide **cómo** hacerlo
- el módulo permanece intacto ante cambios

---

## 🤔 Reflexión (con respuestas)

**¿Por qué un sistema muy acoplado es frágil?**  
Porque un cambio en una parte obliga a modificar muchas otras, aumentando el riesgo de errores.

**¿Cuál es la ventaja principal del desacoplamiento?**  
Permite cambiar, probar y mantener componentes de forma independiente.

**¿Desacoplar significa que los módulos no se comuniquen?**  
No. Significa que se comuniquen mediante contratos claros, sin conocer detalles internos.

**¿Por qué el desacoplamiento facilita las pruebas?**  
Porque los componentes pueden probarse de forma aislada, usando implementaciones simuladas.

---

## ✍️ Resumen

🌱 **El desacoplamiento** es un principio fundamental del diseño de software que busca  
reducir dependencias entre componentes.  
Al depender de abstracciones y no de implementaciones concretas, los sistemas se vuelven  
más flexibles, testeables y fáciles de mantener.  
Frameworks como **Spring** refuerzan este principio al encargarse de crear y conectar los componentes.
