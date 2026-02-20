# Anotaciones en Spring

Las **anotaciones en Spring** son una forma moderna de **configurar el comportamiento del contenedor** directamente desde el código fuente, sin necesidad de archivos XML extensos.  
Funcionan como **metadatos**: no contienen lógica de negocio, sino **instrucciones para el framework**.

Spring las utiliza para saber:

- qué clases debe gestionar
- cómo crear los objetos (beans)
- cómo relacionarlos entre sí
- cuándo inicializarlos y destruirlos
- qué rol cumple cada componente dentro de la aplicación
    
---

## 🧠 Idea clave

> Las anotaciones **no hacen magia**:  
> simplemente reemplazan lo que antes se escribía en XML.

Todo lo que se puede hacer con anotaciones **también se puede hacer con XML**.  
La diferencia está en **dónde vive la configuración**.

---

## 📦 ¿Qué problema resuelven?

Antes de las anotaciones:

- la configuración estaba **separada del código**
- los XML crecían demasiado
- era difícil saber qué clase hacía qué
- la configuración y la lógica estaban desconectadas
    
Con anotaciones:

- la configuración vive **junto a la clase**
- se reduce el XML
- el código es más legible
- el mantenimiento es más simple
    
---

## 🔁 Anotaciones y el contenedor IoC

Las anotaciones existen para **comunicar decisiones al contenedor IoC**.

Por ejemplo, indicarle:

- “esta clase debe ser un bean”
- “esta dependencia debe inyectarse aquí”
- “este objeto debe existir una sola vez”
- “este método se ejecuta al iniciar”
    
El contenedor **lee las anotaciones**, interpreta sus significados y actúa en consecuencia.

---

## 🧩 Tipos conceptuales de anotaciones en Spring

### 1️⃣ Anotaciones de **registro de beans**

Indican que una clase debe ser administrada por Spring.
Conceptualmente responden a la pregunta:

> ¿Este objeto debe existir dentro del contenedor?

Ejemplos conceptuales:

- componentes genéricos
- servicios
- repositorios
- controladores
    
Su función es **registrar clases como beans** sin declararlos en XML.

---

### 2️⃣ Anotaciones de **inyección de dependencias**

Indican **cómo y dónde** se deben inyectar otros objetos.
Conceptualmente responden a:

> ¿De dónde obtiene esta clase sus dependencias?

Permiten:

- inyectar por constructor
- inyectar por método
- inyectar directamente en campos
    
Reemplazan:

- `<constructor-arg>`
- `<property>`
    
---

### 3️⃣ Anotaciones de **configuración**

Permiten definir reglas generales del contenedor.

Sirven para:

- habilitar escaneo de clases
- cargar configuraciones
- declarar beans manualmente
- definir comportamientos globales
    
Aquí Spring deja de depender de XML y usa **clases Java como configuración**.

---

### 4️⃣ Anotaciones de **ciclo de vida**

Indican acciones que deben ejecutarse:

- antes de que el bean esté listo
- justo antes de destruirse
    
Conceptualmente responden a:

> ¿Qué debe hacer este objeto al iniciar o al finalizar?

Reemplazan:

- `init-method`
- `destroy-method`
    

---

### 5️⃣ Anotaciones de **alcance (scope)**

Definen **cuántas instancias** puede tener un bean.

Responden a:

> ¿Este objeto es compartido o independiente?

Permiten controlar:

- singleton
- prototype
- otros alcances especiales
    
---

## 🔄 Anotaciones vs XML (comparación mental)

|XML|Anotaciones|
|---|---|
|Configuración centralizada|Configuración distribuida|
|Más verboso|Más conciso|
|Separado del código|Unido al código|
|Fácil de ver todo|Fácil de mantener|
|Ideal para legacy|Ideal para proyectos modernos|

📌 **Spring no obliga a elegir uno**  
Puedes usar **XML + anotaciones + Java Config** juntos.

---

## ⚠️ Consideraciones importantes

- Las anotaciones **acoplan configuración y código**
- Cambiar comportamiento implica recompilar
- Un exceso de anotaciones puede ocultar la arquitectura
- En proyectos grandes, se recomienda combinarlas con Java Config
    
---

## 🧠 Resumen mental

- Las anotaciones **son instrucciones, no lógica**
- Le dicen a Spring _qué hacer_, no _cómo hacerlo_
- Reemplazan XML, no cambian el modelo
- IoC y DI siguen siendo exactamente los mismos
- Solo cambia la forma de expresar la configuración