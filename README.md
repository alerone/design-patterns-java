# Patrones de diseño en Java con Spring Boot — ShopLab

Repositorio de estudio del curso **«Patrones de diseño en Java con Spring Boot»** (Fábrica de Cursos, PDF en [`docs/design-patterns.pdf`](docs/design-patterns.pdf)). El libro recorre los 23 patrones GoF con Java 21 y Spring Boot 4.1 mientras se construye una tienda de ejemplo llamada **ShopLab**.

## Propósito

Este repositorio **no es un producto**, es un cuaderno de trabajo. Sirve para:

- Practicar cada patrón de diseño primero en **Java puro** y después en su forma idiomática en **Spring** (beans, `@Configuration`, inyección de dependencias, AOP…).
- Hacer los ejercicios de cada capítulo y hacer crecer ShopLab hito a hito.
- Guardar una "foto" del proyecto al terminar cada capítulo, para poder volver atrás y comparar.

## Estructura

| Carpeta | Qué contiene |
|---|---|
| [`shoplab-c02/`](shoplab-c02) | Estado de ShopLab con los ejercicios del **capítulo 2** (Singleton y el contenedor de Spring). |
| [`shoplab-c03/`](shoplab-c03) | Estado con los ejercicios del **capítulo 3** (Factory Method y Abstract Factory, primeras pruebas con JUnit). |
| [`shoplab/`](shoplab) | Proyecto "vivo": continúa donde acabó el cap. 3 y contiene el trabajo del **capítulo 4** (Builder y Prototype con Lombok). |
| [`docs/design-patterns.pdf`](docs/design-patterns.pdf) | El libro del curso. |
| [`read.sh`](read.sh) | Abre el PDF con `evince`. |

Dentro de cada proyecto, el código del dominio está en `src/main/java/shoplab/` y los ejercicios sueltos del libro en `src/main/java/shoplab/ejercicios/`.

## Cómo funciona

ShopLab es una API REST con **Spring Boot 4.1**, **Java 21** y **Gradle**. Los datos viven en memoria (no hay base de datos), así que se pierden al reiniciar.

**Dominio (`shoplab`)**

- `Money` — `record` con `BigDecimal` y moneda; redondea a 2 decimales y valida (sin negativos, misma moneda al sumar/restar).
- `Product` — `record` validado en su constructor compacto.
- `ProductKind` — interfaz **sellada** con `Physical`, `Digital` y `Service`; se serializa a JSON con un campo `type`.
- `ProductRepository` / `InMemoryRepository` — repositorio en memoria sobre un `ConcurrentHashMap`.
- `ProductController` — endpoints `POST /products`, `GET /products` y `GET /products/{id}`.
- `PaymentProcessor` (`CardProcessor`, `BankTransferProcessor`) y `PaymentProcessorFactory` — pagos elegidos según `PaymentType` (cap. 3).
- `ShippingAddress` — dirección de envío con Builder de Lombok (cap. 4).

**Ejercicios (`shoplab.ejercicios`)** — pequeñas clases, algunas con `main` o `ApplicationRunner` que imprimen un resultado por consola para comprobar el ejercicio (`*Check`): Singleton con el idioma del holder, carrera de hilos, `@Bean` y ámbitos, selección de formateadores por `@Qualifier`, OCP con descuentos, `switch` con patrones para el coste de envío, `ShopSettings` leído desde `application.properties`, etc.

## Qué se puede probar por ahora

Requisitos: **JDK 21**. El wrapper de Gradle ya está incluido (`./gradlew`).

### Capítulo 3 — `shoplab-c03` (estado estable)

```bash
cd shoplab-c03
./gradlew test       # MoneyTest y test de contexto
./gradlew bootRun    # arranca en :8080 e imprime las salidas de los *Check
```

Al arrancar se ejecuta `FormatterCheck` y verás en consola los formatos `json`, `csv`, el formato por defecto y el error de un formato desconocido (`xml`).

API de productos (ejemplo en [`shoplab/test.txt`](shoplab/test.txt)):

```bash
curl -i -H "Content-Type: application/json" -d '{
  "id": "p1",
  "name": "Teclado",
  "price": { "amount": 49.9, "currency": "EUR" },
  "kind": { "type": "physical", "weightGrams": 800 },
  "stock": 12,
  "category": "hardware"
}' http://localhost:8080/products

curl http://localhost:8080/products
curl http://localhost:8080/products/p1
```

Otros endpoints y comprobaciones:

- `GET /settings` — `ShopSettings` cargado desde `application.properties` (`shop.store-name`, `shop.default-currency`, `shop.max-items-per-order`).
- Ejecutables con `main` (desde el IDE): `RaceCheck` (Singleton perezoso frente a holder con 8 hilos), `ShopRegistryCheck`, `MoneyCheck`, `PaymentFactoryCheck`, `ShippingCost`.

### Capítulo 2 — `shoplab-c02`

Mismo arranque (`./gradlew bootRun`). Incluye los ejercicios de Singleton y del contenedor de Spring: `ShopRegistry`, `PromoCodeBook`, `TicketCounter`/`TicketAudit`/`TicketConfiguration` y el ejercicio OCP de descuentos (`ejercicios/ocp`).

### Capítulo 4 — `shoplab` (trabajo en curso)

Lo hecho hasta ahora son los ejercicios 4.1 a 4.3: Lombok añadido al `build.gradle`, `ShippingAddress` con `@Value`, `@Builder`, `@Jacksonized` y `@Singular`, y su versión escrita a mano (`ManualShippingAddress`) para comparar.

> ⚠️ **Estado actual:** esta carpeta aún no compila (`./gradlew compileJava` falla):
> - `ApiExceptionHandler` referencia `ApiError` y `ProductNotFoundException`, que todavía no existen.
> - `@Jacksonized` importa `com.fasterxml.jackson.databind.annotation`, que no está en el classpath de Spring Boot 4 (usa Jackson 3, paquete `tools.jackson`).
>
> Los pedidos del hito 3 (`POST /orders`, `GET /orders/{id}`, `POST /orders/{id}/repeat`) tampoco existen aún. Mientras tanto, usa `shoplab-c03` para probar la aplicación.

## Aprendizajes del último capítulo (cap. 4 — Builder y Prototype, con Lombok)

Capítulo en curso: ejercicios 4.1 a 4.3 hechos; faltan 4.4 (copiar una lista de deseos), 4.5 (pedido repetido) y 4.6 (hito 3: pedidos).

- **El olor que motiva el Builder:** el constructor telescópico (¿qué es cada argumento? ¿por qué hay `null`s?) y los setters que dejan objetos a medio construir.
- **Builder a mano (4.2):** un objeto auxiliar con un método por dato que devuelve `this` y un `build()` que **valida y entrega el objeto ya válido** (`ManualShippingAddress`). Es verboso, y ahí se ve el valor de Lombok.
- **Lombok en Gradle (4.1):** `compileOnly` + `annotationProcessor` en `build.gradle`.
- **Builder con Lombok (4.3):**
  - `@Value` → clase inmutable (campos `private final`, getters, `equals`/`hashCode`/`toString`).
  - `@Builder` → genera el Builder; `@Builder.Default` da valores por defecto (`country = "ES"`); `@Singular("deliveryNote")` permite añadir elementos de la lista uno a uno.
  - `@Jacksonized` → hace que Jackson deserialice el JSON usando el Builder.
- **Validación en el constructor explícito:** Lombok delega en el constructor que escribes, así que ahí van las reglas (campos obligatorios, `List.copyOf` para copia defensiva).
- **Traducción de excepciones a HTTP** con `@RestControllerAdvice` y `@ExceptionHandler` (en preparación).
- **Spring Boot 4 usa Jackson 3**, así que `@Jacksonized` de Lombok (que apunta a `com.fasterxml.jackson`) no encaja sin más: a resolver.

## Aprendizajes del curso hasta ahora

### Capítulo 1 — Java 21 moderno, SOLID y el esqueleto de ShopLab

- **Records** y constructores compactos para tipos de valor inmutables y validados.
- **`BigDecimal` para dinero** (nunca `double`) y un tipo `Money` propio con escala y redondeo fijos.
- **Interfaces selladas + `switch` con patrones** (incluidos *record patterns* y guardas `when`): el compilador verifica que cubres todos los casos, sin `default`.
- **SOLID** con ejemplos reales: SRP, OCP (ampliar sin editar, ejercicio de descuentos), LSP, ISP y DIP.
- Generar un proyecto con **Spring Initializr**, el `build.gradle`, el wrapper de Gradle y el primer arranque.
- Serialización polimórfica con Jackson (`@JsonTypeInfo` / `@JsonSubTypes`) y un repositorio en memoria.
- Cómo defender un patrón en una code review: nombrar el problema (el "olor") antes de aplicar la solución.

### Capítulo 2 — Singleton y el contenedor de Spring

- Singleton en Java puro: inicialización perezosa y sus problemas de concurrencia, **idioma del holder** y Singleton con `enum`.
- Críticas al patrón: estado global y acoplamiento.
- En Spring, **el contenedor es el Singleton**: beans con `@Configuration`/`@Bean`, `ApplicationContext.getBean` y el ámbito `prototype`.
- Cuándo sí y cuándo no usar un Singleton; comprobar la teoría con hilos (`RaceCheck`).

### Capítulo 3 — Factory Method y Abstract Factory

- El olor de los `new` y `switch` por tipo repartidos por el código.
- **Factory Method** clásico y parametrizado (`PaymentProcessorFactory` con `switch` sobre un `enum`).
- **`@Bean` como método de fábrica**, varios beans del mismo tipo y elección con `@Qualifier`; inyectar un `Map<String, Bean>` para elegir por nombre (`DocumentService`).
- **Abstract Factory** para familias de objetos coherentes, y su equivalente con beans.
- Diferencias entre Factory Method, Abstract Factory y fábricas estáticas.
- **Primeras pruebas con JUnit**: anatomía de un test (`MoneyTest`) y `@SpringBootTest`.
- Externalizar configuración con `application.properties` y `@Value`.

## Próximos pasos

Terminar los ejercicios 4.4 a 4.6 (Prototype y pedidos con Builder), arreglar la compilación de `shoplab` y continuar con los patrones estructurales: Adapter, Facade, Bridge, Composite, Decorator, Proxy y Flyweight.
