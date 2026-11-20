# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Diseño y Validación de API REST**.

| | |
|---|---|
| Tema | Diseño de APIs REST con validación de entrada |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar (dominio, aplicación, infraestructura) |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.h2database:h2
- jakarta.persistence:jakarta.persistence-api
- jakarta.validation:jakarta.validation-api
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del Recurso REST**: Descripción del recurso REST y sus endpoints, incluyendo los campos requeridos y los códigos de estado HTTP.
- **Fase 2 — Implementación de Validación Declarativa**: Recurso REST con validaciones declarativas implementadas y respuestas de error uniformes.
- **Fase 3 — Pruebas de Controlador**: Conjunto de pruebas unitarias para el controlador del recurso REST, cubriendo casos de éxito y de error.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/application/service/LoanService.java` — La pieza p1 (Definición de casos de uso para préstamos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/controller/LoanController.java` — La pieza p2 (Exposición de endpoints REST con códigos de estado correctos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/service/LoanValidationService.java` — La pieza p3 (Validación declarativa de reglas de negocio, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/exception/GlobalExceptionHandler.java` — La pieza p4 (Mapeo de excepciones a respuestas de error uniformes, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/service/LoanTestDataBuilder.java` — La pieza p5 (Construcción de datos de prueba para casos de borde, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/domain/model/Loan.java` — absorbida: fuga de la pieza p3

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Definición del Recurso REST | Definición de casos de uso para préstamos | `src/main/java/application/service/LoanService.java:LoanService` | El recurso REST expone los endpoints para crear y consultar préstamos con los campos definidos.; Los códigos de estado HTTP son correctos para cada operación.; La estructura de la respuesta incluye los campos requeridos y errores uniformes. | — | — |
| f1 — Definición del Recurso REST | Exposición de endpoints REST con códigos de estado correctos | `src/main/java/infrastructure/controller/LoanController.java:LoanController` | El recurso REST expone los endpoints para crear y consultar préstamos con los campos definidos.; Los códigos de estado HTTP son correctos para cada operación.; La estructura de la respuesta incluye los campos requeridos y errores uniformes. | — | — |
| f2 — Implementación de Validación Declarativa | Validación declarativa de reglas de negocio | `src/main/java/application/service/LoanValidationService.java:LoanValidationService` | Las validaciones declarativas están aplicadas a los campos del recurso.; Los errores de validación devuelven códigos de estado HTTP 400 con mensajes uniformes.; El controlador maneja correctamente los errores de validación sin devolver 500. | — | — |
| f2 — Implementación de Validación Declarativa | Mapeo de excepciones a respuestas de error uniformes | `src/main/java/infrastructure/exception/GlobalExceptionHandler.java:GlobalExceptionHandler` | Las validaciones declarativas están aplicadas a los campos del recurso.; Los errores de validación devuelven códigos de estado HTTP 400 con mensajes uniformes.; El controlador maneja correctamente los errores de validación sin devolver 500. | — | — |
| f3 — Pruebas de Controlador | Construcción de datos de prueba para casos de borde | `src/main/java/application/service/LoanTestDataBuilder.java:LoanTestDataBuilder` | Las pruebas cubren todos los endpoints del recurso con casos de éxito y error.; Las pruebas validan los códigos de estado HTTP y la estructura de las respuestas.; Las pruebas aíslan el controlador de dependencias externas. | — | — |
| f3 — Pruebas de Controlador | Pruebas de integración para controladores REST | `src/main/java/infrastructure/controller/LoanController.java:LoanControllerTest` | Las pruebas cubren todos los endpoints del recurso con casos de éxito y error.; Las pruebas validan los códigos de estado HTTP y la estructura de las respuestas.; Las pruebas aíslan el controlador de dependencias externas. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Conoce Spring pero devuelve 500 en errores de validación del cliente | `src/main/java/infrastructure/controller/LoanController.java:LoanController` | Verificada |
| Conoce Spring pero devuelve 500 en errores de validación del cliente | `src/test/java/acceptance/f1/AcceptanceTest.java` > shouldReturn400WhenLoanRequestIsInvalid | Restriccion no verificada en `src/test/java/acceptance/f1/AcceptanceTest.java` > shouldReturn400WhenLoanRequestIsInvalid |
| Conoce Spring pero devuelve 500 en errores de validación del cliente | chequeo estatico (code): exige `400`, `@Valid`; prohibe `500` | Restriccion no verificada en chequeo estatico (code): exige `400`, `@Valid`; prohibe `500` |

## Lo que falta y tenes que completar

### 1. Referencias colgando (14)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setId`
      Se invoca `setId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setCustomerId`
      Se invoca `setCustomerId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setAmount`
      Se invoca `setAmount` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setInterestRate`
      Se invoca `setInterestRate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setStartDate`
      Se invoca `setStartDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setEndDate`
      Se invoca `setEndDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setStatus`
      Se invoca `setStatus` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getId`
      Se invoca `getId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getCustomerId`
      Se invoca `getCustomerId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getAmount`
      Se invoca `getAmount` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getInterestRate`
      Se invoca `getInterestRate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getStartDate`
      Se invoca `getStartDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getEndDate`
      Se invoca `getEndDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getStatus`
      Se invoca `getStatus` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (14)

- `pom.xml`
- `src/main/java/domain/model/Loan.java`
- `src/main/java/domain/port/LoanRepository.java`
- `src/main/java/application/dto/CreateLoanRequest.java`
- `src/main/java/application/exception/ValidationError.java`
- `src/main/java/infrastructure/exception/ErrorResponse.java`
- `src/main/java/application/service/LoanService.java`
- `src/main/java/infrastructure/controller/LoanController.java`
- `src/main/java/application/service/LoanValidationService.java`
- `src/main/java/infrastructure/exception/GlobalExceptionHandler.java`
- `src/main/java/application/service/LoanTestDataBuilder.java`
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java`
- `src/main/resources/application.properties`
- `src/main/java/Application.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/bank/loan/domain/model` (ausente)
- `src/main/java/com/bank/loan/domain/port` (ausente)
- `src/main/java/com/bank/loan/application/dto` (ausente)
- `src/main/java/com/bank/loan/application/service` (ausente)
- `src/main/java/com/bank/loan/infrastructure/controller` (ausente)
- `src/main/java/com/bank/loan/infrastructure/exception` (ausente)
- `src/main/java/com/bank/loan/infrastructure/config` (ausente)
- `src/main/resources` (presente)
- `src/test/java/com/bank/loan/application/service` (ausente)
- `src/test/java/com/bank/loan/infrastructure/controller` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (dominio, aplicación, infraestructura)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Expone recursos REST con validación declarativa de la entrada, códigos de estado correctos y respuestas de error uniformes.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
